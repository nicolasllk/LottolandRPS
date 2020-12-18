package com.exercise.lottolandRPS.model;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

import static org.testng.Assert.*;
public class PlayerTest {
    private Player player;

    @BeforeMethod
    public void testSetup() {
        player = new Player("player1");
    }
    @Test
    public void testPlayerGetScore() {
        assertEquals(player.getScore(), 0);
    }

    @Test
    public void testPlayerGetSelection() {
        assertEquals(player.getSelection(), Selection.NULL_SELECTION);
    }

    @Test
    public void testPlayerGetName() {
        assertEquals(player.getName(), "player1");
    }

    @Test
    public void testPlayerGetFixedSelection() {
        player.choose(() -> Selection.ROCK);
        for (int i = 0 ; i < 10 ; i++)
            assertEquals(player.getSelection(), Selection.ROCK);
    }

    @Test
    public void testPlayerGetRandomSelection() {
        Selection currentSelection = player.choose(() -> Selection.values()[new Random().nextInt(3) + 1]);
        for (int i = 0 ; i < 10 ; i++)
            assertTrue(player.getSelection() != Selection.NULL_SELECTION);
            assertTrue((player.getSelection() == Selection.ROCK)
                    || (player.getSelection() == Selection.SCISSORS)
                    || (player.getSelection() == Selection.PAPPER));
            assertEquals(player.getSelection(), currentSelection);
    }
}