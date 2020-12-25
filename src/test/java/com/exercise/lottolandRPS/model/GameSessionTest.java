package com.exercise.lottolandRPS.model;

import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;
public class GameSessionTest {

    @Test
    public void testNewGameSession() {
        GameSession session = new GameSession(generatePlayerList());

        assertEquals(session.getRounds().size(), 0);
        assertEquals(session.getPlayers().size(), 2);
    }

    @Test
    public void testSessionRoundCount() {
        GameSession session = new GameSession(generatePlayerList());
        session.addRound(new Round(0));

        assertEquals(session.getRounds().size(), 1);
        assertEquals(session.getPlayers().size(), 2);
    }

    @Test
    public void testAddRoundToSession() {
        GameSession session = new GameSession(generatePlayerList());

        session.addRound(new Round(0));
        assertEquals(session.getRounds().size(), 1);

        session.addRound(new Round(1));
        assertEquals(session.getRounds().size(), 2);
    }

    @Test
    public void testResetSession() {
        GameSession session = new GameSession(generatePlayerList());

        session.addRound(new Round(0));
        session.addRound(new Round(1));
        assertEquals(session.getRounds().size(), 2);

        session.reset();
        assertEquals(session.getRounds().size(), 0);
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