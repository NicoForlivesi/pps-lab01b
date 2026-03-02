package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class CoreBankAccountTest {

    protected static final int INITIAL_BALANCE = 0;
    protected static final int DEPOSIT_AMOUNT = 1000;
    protected static final int WITHDRAW_AMOUNT = 200;

    protected BankAccount account;

    @BeforeEach
    void init(){
        this.account = new CoreBankAccount();
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(INITIAL_BALANCE, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(DEPOSIT_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT, this.account.getBalance());
    }
}
