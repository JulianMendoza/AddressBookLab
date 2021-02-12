package com.addressbook.app;

import com.addressbook.app.WebController;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class WebAppTests {

    @LocalServerPort
    private int port;
    @Autowired
    private WebController controller;

    @Test
    public void contextLoads(){
        Assertions.assertThat(controller).isNotNull();
    }
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void formPageLoads() throws Exception {
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/home",
                String.class)).contains("Name:");
    }


}
