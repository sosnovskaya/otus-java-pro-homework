package ru.otus.homework.proxy;


import ru.otus.homework.proxy.hadnlers.TestLoggingInvocationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Ioc {

    private Ioc() {
    }

    public static TestLoggingInterface createTestLogging() {
        InvocationHandler handler = new TestLoggingInvocationHandler(new TestLogging());
        return (TestLoggingInterface) Proxy.newProxyInstance(Ioc.class.getClassLoader(),
                new Class<?>[]{TestLoggingInterface.class}, handler);
    }
}
