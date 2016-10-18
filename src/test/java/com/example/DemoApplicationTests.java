package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {

    @LocalServerPort
    private int port;

    @Test
    public void contextLoads() {
    }

    @Test
    public void idPropertyIsIgnored() {
        final TestRestTemplate restTemplate = new TestRestTemplate();
        final String response = restTemplate.getForObject("http://localhost:" + port, String.class);
        assertThat(response).doesNotContain("\"id\"");
    }
}
