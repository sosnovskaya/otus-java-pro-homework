package ru.otus.homework.proxy;

import ru.otus.homework.annotations.Log;

public class TestLogging implements TestLoggingInterface {

	@Log
	@Override
	public void calculation(int param1) {

	}
	@Log
	@Override
	public void calculation(int param1, int param2) {

	}
	@Log
	@Override
	public void calculation(int param1, int param2, String param3) {

	}

	@Override
	public void calculation(String param1) {

	}
}
