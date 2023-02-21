package ru.otus.homework.abstractfactory;

import ru.otus.homework.atm.ATMEmulator;

public interface ATMFactory<T extends Enum> {

	public ATMEmulator createATM();
}
