package ru.otus.homework.proxy.hadnlers;

import ru.otus.homework.annotations.Log;
import ru.otus.homework.proxy.TestLogging;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestLoggingInvocationHandler implements InvocationHandler {
	private final TestLogging externalClass;

	public TestLoggingInvocationHandler(TestLogging myClass) {
		this.externalClass = myClass;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(checkTestAnnotation(method)) {
			processTestAnnotation(method, args);
		}
		return method.invoke(externalClass, args);
	}

	private boolean checkTestAnnotation(Method method) {
		return method.isAnnotationPresent(Log.class);
	}

	private void processTestAnnotation(Method method, Object[] args) {
		System.out.println("executed method: " + method.getName() + ", params: " + Arrays.toString(args));
	}
}
