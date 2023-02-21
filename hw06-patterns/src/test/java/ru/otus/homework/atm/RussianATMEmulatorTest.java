package ru.otus.homework.atm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.homework.banknotes.RussianBanknotes;
import ru.otus.homework.configuration.Configuration;
import ru.otus.homework.configuration.enums.Country;
import ru.otus.homework.exceptions.BalanceATMException;
import ru.otus.homework.exceptions.IncomeATMException;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Russian ATM test")
class RussianATMEmulatorTest {

	private ATMEmulator atm;

	@BeforeEach
	void setUp() {
		atm = Configuration.configuration(Country.RUSSIA);
	}

	@Test
	public void testATMEmulator1() {
		atm.acceptBanknotes(RussianBanknotes.TEN, 4);
		atm.acceptBanknotes(RussianBanknotes.TWO_THOUSAND, 1);
		atm.acceptBanknotes(RussianBanknotes.ONE_HUNDRED, 3);

		var balance = atm.getAccountBalance();

		assertThat(balance).isEqualTo(2340);
	}

	@Test
	public void testATMEmulator2() {
		atm.acceptBanknotes(RussianBanknotes.ONE_THOUSAND, 8);
		atm.acceptBanknotes(RussianBanknotes.ONE_HUNDRED, 7);
		atm.acceptBanknotes(RussianBanknotes.TEN, 6);
		var expected = new HashMap<RussianBanknotes, Integer>() {{
			put(RussianBanknotes.FIVE_THOUSAND, 1);
			put(RussianBanknotes.TWO_THOUSAND, 1);
			put(RussianBanknotes.ONE_THOUSAND, 1);
			put(RussianBanknotes.FIVE_HUNDRED, 1);
			put(RussianBanknotes.TWO_HUNDRED, 1);
			put(RussianBanknotes.FIFTY, 1);
			put(RussianBanknotes.TEN, 1);
		}};

		var actual = atm.getRequestedAmountOfMoney(8760);

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void testATMEmulator3() {
		atm.acceptBanknotes(RussianBanknotes.ONE_THOUSAND, 8);
		atm.acceptBanknotes(RussianBanknotes.ONE_HUNDRED, 7);
		atm.acceptBanknotes(RussianBanknotes.TEN, 6);

		Exception exception = assertThrows(IncomeATMException.class, () -> {
			atm.getRequestedAmountOfMoney(-100);
		});
	}

	@Test
	public void testATMEmulator4() {
		atm.acceptBanknotes(RussianBanknotes.ONE_THOUSAND, 8);
		atm.acceptBanknotes(RussianBanknotes.ONE_HUNDRED, 7);
		atm.acceptBanknotes(RussianBanknotes.TEN, 6);

		Exception exception = assertThrows(BalanceATMException.class, () -> {
			atm.getRequestedAmountOfMoney(8763);
		});
	}
}