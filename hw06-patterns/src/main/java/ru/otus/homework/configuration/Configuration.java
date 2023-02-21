package ru.otus.homework.configuration;

import ru.otus.homework.abstractfactory.ATMFactory;
import ru.otus.homework.abstractfactory.RussianATMFactory;
import ru.otus.homework.atm.ATMEmulator;
import ru.otus.homework.configuration.enums.Country;

public class Configuration {

	public static ATMEmulator configuration(Country country) {
		return factoryConfiguration(country).createATM();
	}

	private static ATMFactory factoryConfiguration(Country country) {
		switch (country) {
			default:
				return new RussianATMFactory();
		}
	}
}
