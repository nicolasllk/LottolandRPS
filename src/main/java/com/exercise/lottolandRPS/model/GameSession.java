package com.exercise.lottolandRPS.model;

import java.util.ArrayList;
import java.util.List;

public class GameSession {
    private List<Round> rounds = new ArrayList<>();
    private List<Player> players;

    public GameSession(final List<Player> players) {
        this.players = players;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(final List<Round> rounds) {
        this.rounds = rounds;
    }

    public void addRound(final Round round) {
        this.rounds.add(round);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(final List<Player> players) {
        this.players = players;
    }

    public void addPlayers(final Player player) {
        this.players.add(player);
    }

    public void reset() {
        this.rounds.clear();
    }
}
