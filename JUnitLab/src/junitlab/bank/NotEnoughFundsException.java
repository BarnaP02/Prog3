package junitlab.bank;

/**
 * Ez a kivétel jelzi, ha érvénytelen vagy nem létezõ bankszámlaszámot
 * adtunk meg valamelyik tranzakció során.
 */
public class NotEnoughFundsException extends BankException {

	/**
	 * A kivétel létrehozása.
	 * @param accountNumber A számlaszám, melyen alacsony az egyenleg.
	 */
	public NotEnoughFundsException(String accountNumber) {
		super(accountNumber, "Not enough funds on account " + accountNumber);
	}
}
