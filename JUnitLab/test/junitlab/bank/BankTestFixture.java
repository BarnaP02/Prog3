package junitlab.bank;

import static org.junit.Assert.*;
import junitlab.bank.impl.FirstNationalBank;

import org.junit.Before;
import org.junit.Test;

public class BankTestFixture {

	Bank b;
	String s1;
	String s2;
	
	@Before
	public void setUp() throws AccountNotExistsException {
		b = new FirstNationalBank();
		s1 = b.openAccount();
		b.deposit(s1, 1500);
		s2 = b.openAccount();
		b.deposit(s2, 12000);
	}

	@Test
	public void testTransfer() throws AccountNotExistsException, NotEnoughFundsException {
		b.transfer(s2, s1, 3456);
		assertEquals(b.getBalance(s2), 8544);
		assertEquals(b.getBalance(s1), 4956);
	}
	
	@Test(expected = NotEnoughFundsException.class)
	public void testTransferWithoutEnoughFunds() throws AccountNotExistsException, NotEnoughFundsException {
		b.transfer(s1, s2, 3456);		
	}

}
