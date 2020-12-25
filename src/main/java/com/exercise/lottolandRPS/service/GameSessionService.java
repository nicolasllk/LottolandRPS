package com.exercise.lottolandRPS.service;

import com.exercise.lottolandRPS.model.GameSession;
import com.exercise.lottolandRPS.model.Player;
import com.exercise.lottolandRPS.model.Round;
import com.exercise.lottolandRPS.model.Selection;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public final class GameSessionService {
    public static final int COMPUTER = 1;
    public static final int PLAYER = 0;
    private List<GameSession> activeGameSessions = new ArrayList<>();

    public GameSession getGameSession(final long id) {
        validateSessionId(id);
        return activeGameSessions.get((int) id);
    }

    public long newGameSession() {
        GameSession session = new GameSession(createPlayers());
        activeGameSessions.add(session);
        return activeGameSessions.indexOf(session);
    }

    /**
     * Play a round for the provided session id.
     * @param id the session id the current round belongs to.
     */
    public void playGameRound(final long id) {
        validateSessionId(id);
        GameSession session = getGameSession(id);
        Round round = new Round(session.getRounds().size());
        generatePlayerSelection(session);
        calculateRoundScore(round, session);
        session.addRound(round);
    }

    private void validateSessionId(final long sessionId) {
        if (sessionId >= activeGameSessions.size()) {
            throw new IllegalStateException("Invalid game session");
        }
    }

    private Selection getRandomSelection() {
        return Selection.values()[new Random().nextInt(3) + 1];
    }

    private List<Player> createPlayers() {
        List<Player> players = new ArrayList<>();
        Player p1 = new Player("human");
        Player p2 = new Player("machine");
        players.add(p1);
        players.add(p2);
        return players;
    }

    private void calculateRoundScore(final Round round, final GameSession gameSession) {
        Selection playerSelection = gameSession.getPlayers().get(0).getSelection();
        Selection computerSelection = gameSession.getPlayers().get(1).getSelection();

        switch (playerSelection) {
            case ROCK:
                if (computerSelection.equals(Selection.PAPPER)) {
                    //loose
                    gameSession.getPlayers().get(COMPUTER).incScore(1);
                    round.setWinner(gameSession.getPlayers().get(COMPUTER));
                    round.setLooser(gameSession.getPlayers().get(PLAYER));
                    round.setDraw(false);
                } else if (computerSelection.equals(Selection.SCISSORS)) {
                    //wins
                    gameSession.getPlayers().get(PLAYER).incScore(1);
                    round.setWinner(gameSession.getPlayers().get(PLAYER));
                    round.setLooser(gameSession.getPlayers().get(COMPUTER));
                    round.setDraw(false);
                } else {
                   //tie
                    round.setDraw(true);
                    //To preserve the choosing of each player
                    round.setWinner(gameSession.getPlayers().get(PLAYER));
                    round.setLooser(gameSession.getPlayers().get(COMPUTER));
                }
                break;
            case PAPPER:
                if (computerSelection.equals(Selection.ROCK)) {
                    gameSession.getPlayers().get(PLAYER).incScore(1);
                    round.setWinner(gameSession.getPlayers().get(PLAYER));
                    round.setLooser(gameSession.getPlayers().get(COMPUTER));
                    round.setDraw(false);
                } else if (computerSelection.equals(Selection.SCISSORS)) {
                    gameSession.getPlayers().get(COMPUTER).incScore(1);
                    round.setWinner(gameSession.getPlayers().get(COMPUTER));
                    round.setLooser(gameSession.getPlayers().get(PLAYER));
                    round.setDraw(false);
                } else {
                    //tie
                    round.setDraw(true);
                    //To preserve the choosing of each player
                    round.setWinner(gameSession.getPlayers().get(PLAYER));
                    round.setLooser(gameSession.getPlayers().get(COMPUTER));
                }
                break;
            case SCISSORS:
                if (computerSelection.equals(Selection.ROCK)) {
                    gameSession.getPlayers().get(COMPUTER).incScore(1);
                    round.setWinner(gameSession.getPlayers().get(COMPUTER));
                    round.setLooser(gameSession.getPlayers().get(PLAYER));
                    round.setDraw(false);
                } else if (computerSelection.equals(Selection.PAPPER)) {
                    gameSession.getPlayers().get(PLAYER).incScore(1);
                    round.setWinner(gameSession.getPlayers().get(PLAYER));
                    round.setLooser(gameSession.getPlayers().get(COMPUTER));
                    round.setDraw(false);
                } else {
                    //tie
                    round.setDraw(true);
                    //To preserve the choosing of each player
                    round.setWinner(gameSession.getPlayers().get(PLAYER));
                    round.setLooser(gameSession.getPlayers().get(COMPUTER));
                }
                break;
            default:
                throw new IllegalStateException("Invalid choice");
        }
    }

    private void generatePlayerSelection(final GameSession session) {
        session.getPlayers().get(PLAYER).choose(() -> getRandomSelection());
        session.getPlayers().get(COMPUTER).choose(() -> Selection.ROCK);
    }

    public void reset(final Long id) {
        validateSessionId(id);
        activeGameSessions.get(Math.toIntExact(id)).reset();
    }
}
