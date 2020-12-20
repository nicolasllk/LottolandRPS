package com.exercise.lottolandRPS.model;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.*;
public class RoundTest {

    @Test
    public void testNewRound() {
        Round round = new Round(generatePlayerList());

        Assert.assertEquals(round.getPlayers().size(), 2);
        assertEquals(round.isDraw(), false);
    }

    private List<Player> generatePlayerList() {
        List<Player> playerList = new ArrayList<>();
        Player player1 = Mockito.mock(Player.class);
        playerList.add(player1);
        Player player2 = Mockito.mock(Player.class);
        playerList.add(player2);

        return playerList;
    }
}