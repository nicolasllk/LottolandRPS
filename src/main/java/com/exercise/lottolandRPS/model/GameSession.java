package com.exercise.lottolandRPS.model;

import java.util.ArrayList;
import java.util.List;

public class GameSession {
    private List<Round> rounds = new ArrayList<>();

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(final List<Round> rounds) {
        this.rounds = rounds;
    }

    public void addRound(final Round round) {
        this.rounds.add(round);
    }

    public void reset() {
        this.rounds.clear();
    }
}
