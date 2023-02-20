package ru.otus.homework;

import ru.otus.homework.proxy.Ioc;
import ru.otus.homework.proxy.TestLoggingInterface;

public class Main {

	public static void main(String[] args) {
		TestLoggingInterface testLogging = Ioc.createTestLogging();
		testLogging.calculation(1);
		testLogging.calculation(2, 2);
		testLogging.calculation(3, 3, "3");
		testLogging.calculation("3");
	}
}
