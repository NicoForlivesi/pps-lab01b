package it.unibo.pps.e1;

public class BronzeBankAccount implements BankAccount {

    private static final int FEE = 1;

    private BankAccount base;

    BronzeBankAccount(BankAccount account) {
        this.base = account;
    }

    @Override
    public int getBalance() { return base.getBalance(); }

    @Override
    public void deposit(int amount) {
        base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        final int amountPlusFee = amount + calculateFee(amount);
        if (base.getBalance() < amountPlusFee) {
            throw new IllegalStateException();
        } else {
            base.withdraw(amountPlusFee);
        }
    }

    private int calculateFee(final int amount) {
        return amount >= 100 ? 1 : 0;
    }
}
