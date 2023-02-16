package ru.otus.homework.proxy;

import ru.otus.homework.annotations.Log;

public interface TestLoggingInterface {
	@Log
	public void calculation(int param1);
	@Log
	public void calculation(int param1, int param2);
	@Log
	public void calculation(int param1, int param2, String param3);

	public void calculation(String param1);
}
