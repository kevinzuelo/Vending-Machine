package com.techelevator;

import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;

public class MachineTest {

    Machine test = new Machine();

    @Test
    public void calculate_change_method_returns_transaction_balance_to_zero() throws IOException {
        test.setTransactionBalance(BigDecimal.valueOf(5.00));
        test.calculateChange(test.getTransactionBalance());

       // Assert.assertSame(BigDecimal.valueOf(0), test.getTransactionBalance());
    }



}
