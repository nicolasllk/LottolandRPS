package com.exercise.lottolandRPS.controller;

import com.exercise.lottolandRPS.model.GameSession;
import com.exercise.lottolandRPS.service.GameSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("session")
public class GameController {
    private GameSessionService gameSessionService;

    @Autowired
    public GameController(final GameSessionService gameSessionService) {
        this.gameSessionService = gameSessionService;
    }

    //REST ENDPOINTS NEED TO BE REFINED
    @GetMapping("/status/{id}")
    public GameSession roundStatus(@PathVariable final Long id) {
        return gameSessionService.getGameSession(id);
    }

    @PostMapping("/new")
    public Long create() {
        return gameSessionService.newGameSession();
    }

    //This is VERY insecure since anyone can reset any ongoing round
    @PutMapping("/reset/{id}")
    public ResponseEntity<?> reset(@PathVariable Long id) {
        gameSessionService.reset(id);
        return ResponseEntity.ok("Reset Complete");
    }

    @PostMapping("play/{id}")
    public void playGame(@PathVariable Long id) {
        gameSessionService.playGameRound(id);
    }
}
