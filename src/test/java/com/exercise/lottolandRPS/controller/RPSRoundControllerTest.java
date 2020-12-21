package com.exercise.lottolandRPS.controller;

import com.exercise.lottolandRPS.LottolandRpsApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;


import static org.testng.Assert.*;
@SpringBootTest(classes = LottolandRpsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RPSRoundControllerTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private RPSRoundController rpsRoundController;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testContextLoad() {
        assertFalse(rpsRoundController == null);
    }

    @Test
    public void testRoundStatus() throws Exception {
        assertEquals(this.restTemplate.getForObject("http://localhost:" + port + "/round/status/1", Object.class), null);

    }

    @Test
    public void testNewRound() throws Exception {
        long roundId = this.restTemplate.postForObject("http://localhost:" + port + "/round", null, Long.class);
        assertEquals(roundId, 1L);

    }

    @Test
    public void testResetRound() throws Exception {
        assertEquals(this.restTemplate.getForObject("http://localhost:" + port + "/round/status/1", Object.class), null);
    }
}