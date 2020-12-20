package com.exercise.lottolandRPS.controller;

import com.exercise.lottolandRPS.model.Round;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/round")
public class RPSRoundStatusController {

    @GetMapping("/status/{id}")
    public Round roundStatus(@PathVariable Long id){
        return null;
    }

}
