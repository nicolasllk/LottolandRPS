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

    private static final String RESPONSE_NEW_ROUND_STATUS = "{\"rounds\":[],\"players\":[{\"name\":\"human\",\"score\":0,\"selection\":\"NULL_SELECTION\"},{\"name\":\"machine\",\"score\":0,\"selection\":\"NULL_SELECTION\"}]}";

    @Test
    public void testContextLoad() {
        assertFalse(gameController == null);
    }

    @Test
    public void testInvalidRoundStatus() throws Exception {
        ResponseEntity<String> response = this.restTemplate.getForEntity("http://localhost:" + port + "/session/status/1", String.class);
        assertEquals(response.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Test
    public void testRoundStatus() throws Exception {
        ResponseEntity<Long> responseNew =  this.restTemplate.postForEntity("http://localhost:" + port + "/session/new", null, Long.class);
        long roundID = responseNew.getBody();

        ResponseEntity<String> responseStatus = this.restTemplate.getForEntity("http://localhost:" + port + "/session/status/" + roundID, String.class);
        assertEquals(responseStatus.getStatusCode(), HttpStatus.OK);
        assertTrue(responseStatus.getBody().equals(RESPONSE_NEW_ROUND_STATUS));
    }

    @Test
    public void testNewRound() throws Exception {
        ResponseEntity<Long> response =  this.restTemplate.postForEntity("http://localhost:" + port + "/session/new", null, Long.class);
        assertEquals((long)response.getBody(), 0L);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
}