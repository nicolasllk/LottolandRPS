package com.exercise.lottolandRPS.model;

import java.util.function.Supplier;

public class Player {
    private final String name;
    private int score;
    private Selection selection;

    public Player(final String name) {
        this.name = name;
        this.selection = Selection.NULL_SELECTION;
        this.score = 0;
    }

    public int getScore() {
        return this.score;
    }

    public Selection getSelection() {
        return this.selection;
    }

    public String getName() {
        return this.name;
    }

    public void setScore(final int score) {
        this.score = score;
    }

    /**
     * The player will choose based on the supplier semantics. Allowing custom behaviors for random selection
     * or some specific/fixed selection.
     * @param s
     * @return
     */
    public Selection choose(final Supplier<? extends Selection> s) {
        this.selection = s.get();
        return this.selection;
    }
}
