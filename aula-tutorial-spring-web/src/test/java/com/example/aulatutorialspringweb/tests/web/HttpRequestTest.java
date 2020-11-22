package com.example.aulatutorialspringweb.tests.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String host;

    @BeforeEach
    void setup() throws Exception{
        host = "http://localhost:" + port;
    }

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {

        String result = restTemplate.getForObject(host + "/", String.class);

        assertThat(result).contains("Hello, World");
    }
}