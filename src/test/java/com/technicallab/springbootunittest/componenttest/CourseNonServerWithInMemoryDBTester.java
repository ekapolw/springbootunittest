package com.technicallab.springbootunittest.componenttest;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CourseNonServerWithInMemoryDBTester {

  @Autowired private MockMvc mockMvc;
  @Autowired private ObjectMapper objectMapper;

  @Test
  public void whenAddCourseThenReturnCourse() throws Exception {

    Course course = new Course("MATH101", "Math");

    MvcResult result =
        mockMvc
            .perform(
                post("/courses/add")
                    .contentType("application/json")
                    .content(objectMapper.writeValueAsString(course)))
            .andDo(print())
            .andExpect(status().isOk())
            .andReturn();

    String contentAsString = result.getResponse().getContentAsString();
    Course enrolledCourse = objectMapper.readValue(contentAsString, Course.class);

    assertEquals(enrolledCourse.getCode(), "MATH101");
    assertEquals(enrolledCourse.getName(), "Math");
  }

  @Test
  public void whenListAllCoursesThenReturnAllCourses() throws Exception {

    mockMvc
        .perform(get("/courses").contentType("application/json"))
        .andDo(print())
        .andExpect(status().isOk());
  }

}
