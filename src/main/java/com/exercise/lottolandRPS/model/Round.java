package com.exercise.lottolandRPS.model;

import java.util.List;

public class Round {
    private List<Player> players;
    private boolean isDraw;

    public Round(final List<Player> players) {
        this.players = players;
        isDraw = false;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(final List<Player> players) {
        this.players = players;
    }

    public void addPlayer(final Player player) {
        this.players.add(player);
    }

    public boolean isDraw() {
        return isDraw;
    }

    public void setDraw(final boolean draw) {
        isDraw = draw;
    }
}
