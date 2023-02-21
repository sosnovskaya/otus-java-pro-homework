package ru.otus.homework.cells;

public interface Cell<T extends Enum> {

	public void acceptBanknotes(int count);

	public int getCellBalance();

	public int getBanknoteAmount();

	public void receiveBanknotes(int count);
}
