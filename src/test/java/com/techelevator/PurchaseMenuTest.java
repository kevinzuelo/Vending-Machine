package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class PurchaseMenuTest {

    PurchaseMenu test = new PurchaseMenu();
    Map<String, Queue> mapTest = new HashMap<>();
    Queue<String> queueTest = new LinkedList<>();
    Machine testMachine = new Machine();

//    @Test
//    public void test_choice_response_if_user_enters_negative_dollar_amount() {
//        // Arrange
//        PurchaseMenu test = new PurchaseMenu();
//        // Act
//        BigDecimal actual = test.choiceResponse(1, mapTest, testMachine);
//        // Assert
//        Assert.assertEquals();
//    }

}
