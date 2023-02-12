package ru.otus.homework;

import ru.otus.homework.runner.TestRunner;
import ru.otus.homework.tests.TestClass;

public class Main {
	public static void main(String[] args) {
		TestRunner.run(TestClass.class.getCanonicalName());
	}
}