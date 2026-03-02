package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SilverBankAccountTest extends CoreBankAccountTest {

    private static final int FEE = 1;
    private static final int INITIAL_BALANCE = 0;
    private static final int DEPOSIT_AMOUNT = 1000;
    private static final int WITHDRAW_AMOUNT = 200;
    private static final int INVALID_WITHDRAW_AMOUNT = 1200;


    @BeforeEach
    void init(){
        this.account = new SilverBankAccount(new CoreBankAccount());
    }

//    @Test
//    public void testInitiallyEmpty() {
//        assertEquals(INITIAL_BALANCE, this.account.getBalance());
//    }
//
//    @Test
//    public void testCanDeposit() {
//        this.account.deposit(DEPOSIT_AMOUNT);
//        assertEquals(DEPOSIT_AMOUNT, this.account.getBalance());
//    }

    @Test
    public void testCanWithdraw() {
        this.account.deposit(DEPOSIT_AMOUNT);
        this.account.withdraw(WITHDRAW_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT - (WITHDRAW_AMOUNT + FEE), this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(DEPOSIT_AMOUNT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(INVALID_WITHDRAW_AMOUNT));
    }

}
