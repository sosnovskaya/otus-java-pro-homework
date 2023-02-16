package ru.otus.homework.proxy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@DisplayName("Proxy")
class ProxyTest {
	private static final String TEXT_TO_PRINT = "executed method";
	private PrintStream backup;
	private ByteArrayOutputStream bos;

	private TestLoggingInterface testLogging;

	@BeforeEach
	void setUp() {
		backup = System.out;
		bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));
		testLogging = Ioc.createTestLogging();
	}

	@AfterEach
	void tearDown() {
		System.setOut(backup);
	}

	@Test
	@DisplayName("должно печатать \"" + TEXT_TO_PRINT + "\"")
	void testAnnotatedLog() throws InterruptedException {
		testLogging.calculation(1);
		assertThat(bos.toString()).contains(TEXT_TO_PRINT);
	}

	@Test
	@DisplayName("не должно печатать \"" + TEXT_TO_PRINT + "\"")
	void testNotAnnotatedLog() {
		testLogging.calculation("1");
		assertThat(bos.toString()).doesNotContain(TEXT_TO_PRINT);
	}
}