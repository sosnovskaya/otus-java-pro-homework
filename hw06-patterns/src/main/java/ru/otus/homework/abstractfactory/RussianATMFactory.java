package ru.otus.homework.abstractfactory;

import ru.otus.homework.atm.ATMEmulator;
import ru.otus.homework.atm.RussianATMEmulator;
import ru.otus.homework.banknotes.RussianBanknotes;

public class RussianATMFactory implements ATMFactory<RussianBanknotes> {
	@Override
	public ATMEmulator createATM() {
		return new RussianATMEmulator();
	}
}
