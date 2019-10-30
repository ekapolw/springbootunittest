package com.technicallab.springbootunittest.componenttest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CourseServerTester {

  @LocalServerPort private int port;
  @Autowired private TestRestTemplate restTemplate;
  @Autowired private ObjectMapper objectMapper;

  @Test
  public void whenAddCourseThenReturnCourse() throws Exception {

    String url = "http://localhost:" + port + "/courses/add";

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    JSONObject courseJsonObject = new JSONObject();
    courseJsonObject.put("code", "MATH101");
    courseJsonObject.put("name", "Math");

    HttpEntity<String> request = new HttpEntity<String>(courseJsonObject.toString(), headers);

    ResponseEntity<Course> response = restTemplate.postForEntity(url, request, Course.class);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody().getCode()).isEqualTo("MATH101");
    assertThat(response.getBody().getName()).isEqualTo("Math");
  }
}