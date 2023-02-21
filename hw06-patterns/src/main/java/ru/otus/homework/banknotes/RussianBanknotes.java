package ru.otus.homework.banknotes;

public enum RussianBanknotes {
	TEN (10),
	FIFTY (50),
	ONE_HUNDRED (100),
	TWO_HUNDRED (200),
	FIVE_HUNDRED (500),
	ONE_THOUSAND (1000),
	TWO_THOUSAND (2000),
	FIVE_THOUSAND (5000);

	private final int rate;

	RussianBanknotes(int rate) {
		this.rate = rate;
	}

	public int getRate() {
		return rate;
	}

	public static int getSize() {
		return values().length;
	}
}
