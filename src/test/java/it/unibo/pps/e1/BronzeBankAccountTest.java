package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BronzeBankAccountTest extends CoreBankAccountTest {

    private static final int DEPOSIT_AMOUNT = 1000;
    private static final int VALID_WITHDRAW_AMOUNT = 200;
    private static final int INVALID_WITHDRAW_AMOUNT = 1500;

    @BeforeEach
    void init () {
        this.account = new BronzeBankAccount(new CoreBankAccount());
    }

    @ParameterizedTest
    @CsvSource({
            "1000, 99, 901",
            "1000, 100, 899"
    })
    public void testCanWithdraw(final int deposit, final int withdraw, final int expected_balance) {
        this.account.deposit(deposit);
        this.account.withdraw(withdraw);
        assertEquals(expected_balance, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(DEPOSIT_AMOUNT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(INVALID_WITHDRAW_AMOUNT));
    }
}
