package com.techelevator;

import org.junit.Test;
import org.junit.Assert;

public class VendingItemTest {

    VendingItem test = new VendingItem("A1", "testBrand", 1.55, "Gum");


    @Test
    public void vending_item_constructor_test(){
        String actual = test.getLocation() + " " + test.getName() + " " + test.getPrice() + " " + test.getType();
        String expected = "A1 testBrand 1.55 Gum";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void print_message_method_returns_correct_message(){
        String actual = test.printMessage();
        String expected = "Chewy Chewy, Yum!";
        Assert.assertEquals(expected, actual);
    }




}
