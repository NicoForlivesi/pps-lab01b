package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class GoldBankAccountTest extends CoreBankAccountTest {

    private static final int DEPOSIT_AMOUNT = 1000;
    private static final int WITHDRAW_AMOUNT = 200;
    private static final int INVALID_WITHDRAW_AMOUNT = 1501;

    @BeforeEach
    void init() {
        this.account = new GoldBankAccount(new CoreBankAccount());
    }

    @ParameterizedTest
    @CsvSource ({
        "1000, 200, 800",
            "1000, 1500, -500"
    })
    void testCanWithdraw(final int deposit_amount, final int withdraw_amount, final int expected_amount){
        this.account.deposit(deposit_amount);
        this.account.withdraw(withdraw_amount);
        assertEquals(expected_amount, account.getBalance());
    }

    @Test
    void testCannotGoUnderMoreThan500() {
        this.account.deposit(DEPOSIT_AMOUNT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(INVALID_WITHDRAW_AMOUNT));
    }
}
