package com.exercise.lottolandRPS.controller;

import com.exercise.lottolandRPS.LottolandRpsApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;


import static org.testng.Assert.*;
@SpringBootTest(classes = LottolandRpsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GameControllerTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private GameController gameController;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testContextLoad() {
        assertFalse(gameController == null);
    }

    @Test
    public void testRoundStatus() throws Exception {
        ResponseEntity<String> response = this.restTemplate.getForEntity("http://localhost:" + port + "/session/status/1", String.class);
        assertEquals(response.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Test
    public void testNewRound() throws Exception {
        Long roundId = this.restTemplate.postForObject("http://localhost:" + port + "/session/new", null, Long.class);
        assertEquals(roundId.longValue(), 0L);
    }
}