package ru.otus.homework.cells;

import ru.otus.homework.banknotes.RussianBanknotes;

public class RussianCell implements Cell<RussianBanknotes> {

	private final RussianBanknotes banknote;
	private int amount;

	public RussianCell(RussianBanknotes banknote) {
		this.banknote = banknote;
		this.amount = 0;
	}

	@Override
	public void acceptBanknotes(int sum) {
		amount += sum;
	}

	@Override
	public int getCellBalance() {
		return amount * banknote.getRate();
	}

	@Override
	public int getBanknoteAmount() {
		return amount;
	}

	@Override
	public void receiveBanknotes(int count) {
	    amount -= count;
	}

	public RussianBanknotes getBanknote() {
		return banknote;
	}

	public int getBanknoteRate() {
		return banknote.getRate();
	}
}
