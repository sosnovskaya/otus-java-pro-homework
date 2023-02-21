package ru.otus.homework;

import ru.otus.homework.atm.ATMEmulator;
import ru.otus.homework.configuration.Configuration;
import ru.otus.homework.configuration.enums.Country;

public class Main {
	public static void main(String[] args) {
		ATMEmulator atmEmulator = Configuration.configuration(Country.RUSSIA);
	}

}
