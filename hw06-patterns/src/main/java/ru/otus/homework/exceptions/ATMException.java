package ru.otus.homework.exceptions;

public class ATMException extends RuntimeException {
	private String message;

	public ATMException(String message) {
		super(message);
	}
}
