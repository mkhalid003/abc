package com.abc.abcdemoservice;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.abc.abcdemoservice.controllers.DemoRestController;

@RunWith(SpringRunner.class)
@WebMvcTest(DemoRestController.class)
public class TestDemoRestController {
 
    @Autowired
    private MockMvc mockMvc;
 
    @Test
    public void ping() throws Exception {
       
    	mockMvc.perform( MockMvcRequestBuilders
    		      .get("/ping")
    		      .accept(MediaType.APPLICATION_JSON))
    		      .andDo(print())
    		      .andExpect(status().isOk());
    	
    }
 
}