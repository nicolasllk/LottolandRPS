package com.exercise.lottolandRPS.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("round")
public class RPSRoundController {

    //REST ENDPOINTS NEED TO BE REFINED
    @GetMapping("/status/{id}")
    public Object roundStatus(@PathVariable Long id) {
        return null;
    }

    @PostMapping
    public Long create() {
        return 1L;
    }

    //This is VERY insecure since anyone can reset any ongoing round
    @PostMapping("reset/{id}")
    public void reset(@PathVariable Long id) {
    }

}
