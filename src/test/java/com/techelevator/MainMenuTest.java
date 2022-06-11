package com.techelevator;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MainMenuTest {

    MainMenu test = new MainMenu();
    Map<String, Queue> mapTest = new HashMap<>();
    Queue<String> queueTest = new LinkedList<>();

    @Test
    public void choice_response_of_1_displays_correct_message() {
        queueTest.offer("A");
        queueTest.offer("B");
        queueTest.offer("C");
        mapTest.put("testKey1", queueTest);
        mapTest.put("testKey2", queueTest);
        mapTest.put("testKey3", queueTest);

        String expected = "A || B || C || Quantity Remaining: 3";

    }






}
