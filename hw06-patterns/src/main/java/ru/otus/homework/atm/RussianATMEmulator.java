package ru.otus.homework.atm;

import ru.otus.homework.banknotes.RussianBanknotes;
import ru.otus.homework.cells.RussianCell;
import ru.otus.homework.exceptions.ATMException;
import ru.otus.homework.exceptions.BalanceATMException;
import ru.otus.homework.exceptions.IncomeATMException;

import java.util.HashMap;
import java.util.Map;

public class RussianATMEmulator implements ATMEmulator{

	private final RussianCell[] cells;

	private final String INCORRECT_DATA_MSG = "Incorrect data! Can not do operation!";

	private final String GIVE_MONEY_ERROR_MSG = "Can not give money!";

	public RussianATMEmulator() {
		this.cells = createCells();
	}

	@Override
	public void acceptBanknotes(RussianBanknotes banknote, int sum) {
		checkIfPositive(sum);
		getCell(banknote).acceptBanknotes(sum);
	}

	@Override
	public Map<RussianBanknotes, Integer> getRequestedAmountOfMoney(int sum) throws ATMException {
		checkIncomeSum(sum);

		Map<RussianBanknotes, Integer> result = new HashMap<>();
		int number = sum;

		for(var i = cells.length - 1; i >= 0; i--) {
			int integer = number / cells[i].getBanknoteRate();
			int remainder = number % cells[i].getBanknoteRate();
			if (integer != 0) {
				result.put(cells[i].getBanknote(), integer);
				number = remainder;
			}
		}

		return result;
	}

	@Override
	public int getAccountBalance() {
		int balance = 0;
		for(var cell : cells) {
			balance += cell.getCellBalance();
		}
		return balance;
	}

	private RussianCell[] createCells() {
		RussianCell[] sortedCells = new RussianCell[RussianBanknotes.getSize()];
		for(var banknote : RussianBanknotes.values()) {
			sortedCells[banknote.ordinal()] = new RussianCell(banknote);
		}
		return sortedCells;
	}

	private RussianCell getCell(RussianBanknotes banknote) {
		return cells[banknote.ordinal()];
	}

	private void checkIfPositive(int sum) {
		if(sum < 0)
			throw new IncomeATMException(INCORRECT_DATA_MSG);
	}

	private void checkIncomeSum(int sum) {
		checkIfPositive(sum);
		if(sum % 10 != 0 || sum < getAccountBalance())
			throw new BalanceATMException(GIVE_MONEY_ERROR_MSG);
	}
}
