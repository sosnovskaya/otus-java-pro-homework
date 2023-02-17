package ru.otus.homework.proxy.hadnlers;

import ru.otus.homework.annotations.Log;
import ru.otus.homework.proxy.TestLogging;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TestLoggingInvocationHandler implements InvocationHandler {
	private final TestLogging externalClass;
	private final Set<String> testLoggingMethods;

	public TestLoggingInvocationHandler(TestLogging myClass) {
		this.externalClass = myClass;
		this.testLoggingMethods = getLogAnnotatedMethods();
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(testLoggingMethods.contains(getSignature(method))) {
			processTestAnnotation(method, args);
		}
		return method.invoke(externalClass, args);
	}
	private Set<String> getLogAnnotatedMethods() {
		var methodsWithAnnotation = new HashSet<String>();
		Method[] testLoggingMethods = TestLogging.class.getMethods();
		for (Method method : testLoggingMethods) {
			if (checkTestAnnotation(method)) {
				methodsWithAnnotation.add(getSignature(method));
			}
		}
		return methodsWithAnnotation;
	}

	private String getSignature(Method method) {
		return method.getName() + Arrays.toString(method.getParameters());
	}

	private boolean checkTestAnnotation(Method method) {
		return method.isAnnotationPresent(Log.class);
	}

	private void processTestAnnotation(Method method, Object[] args) {
		System.out.println("executed method: " + method.getName() + ", params: " + Arrays.toString(args));
	}
}
