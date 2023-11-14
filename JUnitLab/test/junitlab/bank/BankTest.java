package junitlab.bank;

import static org.junit.Assert.*;
import junitlab.bank.impl.FirstNationalBank;
import junitlab.bank.impl.GreatSavingsBank;

import org.junit.Test;
//import static junitlab.bank.impl.FirstNationalBank;

public class BankTest{

	@Test
	public void testOpenAccount() throws AccountNotExistsException {
		Bank b = new FirstNationalBank();
		String s = b.openAccount();
		long balance = b.getBalance(s);
		assertNotNull(balance);
	}

	@Test
	public void testUniqueAccount() {
		Bank b = new FirstNationalBank();
		String s1 = b.openAccount();
		String s2 = b.openAccount();
		//long balance = b.getBalance(s);
		assertNotSame(s1, s2);
	}

	@Test (expected = AccountNotExistsException.class)
	public void testInvalidAccount() throws AccountNotExistsException{
		Bank b = new GreatSavingsBank();
		b.getBalance("leeeroy jenkins");
		//assertNotSame(s1, s2);
	}

	@Test
	public void testDeposit() throws AccountNotExistsException {
		Bank b = new FirstNationalBank();
		String acc = b.openAccount();
		b.deposit(acc, 2000);
		long balance = b.getBalance(acc);
		assertEquals(balance, 2000);
	}

}
