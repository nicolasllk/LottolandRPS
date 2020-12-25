package com.exercise.lottolandRPS.model;

import java.util.List;

public class Round {
    private long id;
    private Player winner;
    private Player looser;
    private boolean isDraw = false;

    public Round(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public boolean isDraw() {
        return isDraw;
    }

    public void setDraw(final boolean draw) {
        isDraw = draw;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(final Player winner) {
        this.winner = new Player(winner.getName(), winner.getSelection(), winner.getScore());
    }

    public Player getLooser() {
        return looser;
    }

    public void setLooser(final Player looser) {
        this.looser = new Player(looser.getName(), looser.getSelection(), looser.getScore());
    }
}
