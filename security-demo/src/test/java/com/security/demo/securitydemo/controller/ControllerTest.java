package com.security.demo.securitydemo.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setBefor() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void query() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/user")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .param("username","123"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))
            .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void findById() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/user/1")
            .contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
            .andReturn().getResponse().getContentAsString();

        System.out.println(result);
    }

    @Test
    public void create() throws Exception {
        String content = "{\"username\":aa,\"password\":\"123\"}";
        String result =  mockMvc.perform(MockMvcRequestBuilders.post("/user/create")
            .content(content)
            .contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn().getResponse().getContentAsString();

        System.out.println(result);
    }

}
