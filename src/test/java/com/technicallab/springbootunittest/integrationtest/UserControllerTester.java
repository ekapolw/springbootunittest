package com.technicallab.springbootunittest.integrationtest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.technicallab.springbootunittest.componenttest.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UserController.class)
public class UserControllerTester {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void whenHTTPRequestThenStatusOK() throws Exception{

        User user = new User(1, "Ekapol");

        when(userRepository.save(user)).thenReturn(user);

        MvcResult result = mockMvc.perform(post("/users/{id}/register?sendWelcomeEmail=true", 1)
                .contentType("application/json")
                .param("sendConfirmEmail", "true")
                .content(objectMapper.writeValueAsString(user)))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String contentAsString = result.getResponse().getContentAsString();
        User addedUser = objectMapper.readValue(contentAsString, User.class);

        assertEquals(addedUser.getId().intValue(), 1);
        assertEquals(addedUser.getName(), "Ekapol");

    }


}
