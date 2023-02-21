package ru.otus.homework.atm;

import ru.otus.homework.banknotes.RussianBanknotes;
import ru.otus.homework.exceptions.ATMException;

import java.util.Map;

public interface ATMEmulator {

	public void acceptBanknotes(RussianBanknotes banknote, int sum);

	public Map<RussianBanknotes, Integer> getRequestedAmountOfMoney(int amount) throws ATMException;

	public int getAccountBalance();
}
