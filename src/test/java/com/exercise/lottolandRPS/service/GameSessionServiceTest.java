package com.exercise.lottolandRPS.service;

import org.testng.annotations.Test;

import static org.testng.Assert.*;
public class GameSessionServiceTest {
    @Test
    public void testNewGameSession() {
        GameSessionService gameSessionService = new GameSessionService();

        assertEquals(gameSessionService.newGameSession(), 0L);
        assertEquals(gameSessionService.getGameSession(0L).getRounds().size(), 0L);
        assertEquals(gameSessionService.getGameSession(0L).getPlayers().size(), 2L);
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public void testStartInvalidGameSession() {
        GameSessionService gameSessionService = new GameSessionService();

        gameSessionService.newGameSession();
        gameSessionService.playGameRound(11L);
    }

    @Test
    public void testPlayGameSessionRound() {
        GameSessionService gameSessionService = new GameSessionService();
        gameSessionService.newGameSession();
        gameSessionService.playGameRound(0L);

        assertEquals(gameSessionService.getGameSession(0L).getRounds().size(), 1);
        gameSessionService.getGameSession(0L).getRounds().get(0);
    }
}