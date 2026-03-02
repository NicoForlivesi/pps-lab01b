package it.unibo.pps.e1;

public class GoldBankAccount implements BankAccount{

    private BankAccount base;

    GoldBankAccount(BankAccount account) {
        this.base = account;
    }

    @Override
    public int getBalance() {
        return base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        if(base.getBalance() - amount >= -500){
            base.withdraw(amount);
        } else { throw new IllegalStateException();}
    }
}
