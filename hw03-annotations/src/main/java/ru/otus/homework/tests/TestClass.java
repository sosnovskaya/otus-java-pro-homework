package ru.otus.homework.tests;

import ru.otus.homework.annotations.After;
import ru.otus.homework.annotations.Before;
import ru.otus.homework.annotations.Test;

public class TestClass {

	@Before
	public void setUp() {
		System.out.print("\n@Before. ");
	}

	@Test
	void anyTest1() {
		System.out.print("@Test: anyTest1. ");
	}

	@Test
	void anyTest2() {
		System.out.print("@Test: anyTest2. ");
		throw new RuntimeException();
	}

	@Test
	void anyTest3() {
		System.out.print("@Test: anyTest3. ");
	}

	@After
	public void tearDown() {
		System.out.print("@After. ");
	}
}
