package ru.otus.homework.runner;

import ru.otus.homework.annotations.After;
import ru.otus.homework.annotations.Before;
import ru.otus.homework.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestRunner {

	private static List<Method> before;
	private static List<Method> after;
	private static List<Method> tests;
	private static Class<?> clazz;
	private static int failedTests;
	private static int successfulTests;

	public static void run(String testClassName) {
		setUpTestRunner(testClassName);
		runTests();
	}

	private static void setUpTestRunner(String className) {
		init();
		try {
			clazz = Class.forName(className);
		} catch (ClassNotFoundException e) {
			System.out.println("Не найден указанный класс" + className);
			throw new RuntimeException(e);
		}

		List<Method> methods = Arrays.asList(clazz.getDeclaredMethods());
		methods.forEach(TestRunner::sortAnnotatedMethods);
	}

	private static void runTests() {
		tests.forEach(TestRunner::runTest);
		printTestStatistic();
	}

	private static void runTest(Method method) {
		var testClass = instantiateNoArgConstructor(clazz);
		before.forEach(before -> callMethod(testClass, before));
		try {
			callMethod(testClass, method);
			successfulTests += 1;
		} catch (Exception e) {
			failedTests += 1;
		} finally {
			after.forEach(after -> callMethod(testClass, after));
		}
	}

	private static void init() {
		before = new ArrayList<>();
		after = new ArrayList<>();
		tests = new ArrayList<>();
		clazz = null;
		failedTests = 0;
		successfulTests = 0;
	}

	private static void sortAnnotatedMethods(Method method) {
		if (method.isAnnotationPresent(Before.class))
			before.add(method);
		if (method.isAnnotationPresent(After.class))
			after.add(method);
		if (method.isAnnotationPresent(Test.class))
			tests.add(method);
	}

	public static <T> T instantiateNoArgConstructor(Class<T> type) {
		try {
			return type.getDeclaredConstructor().newInstance();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void callMethod(Object object, Method method, Object... args) {
		try {
			method.setAccessible(true);
			method.invoke(object, args);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static void printTestStatistic() {
		System.out.println("\nTotal tests: " + tests.size() + ", passed: " + successfulTests + ", failed: " + failedTests);
	}
}
