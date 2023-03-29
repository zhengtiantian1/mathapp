package com.project.math.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class MathControllerTest {

    @Autowired
    private MathController mathController;

    @Autowired
    private MockMvc mockMvc;


    @Test
    void getMinNumber() throws Exception {

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("numbers","1,2,3,4,5");
        params.add("quantifier","2");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/min").params(params))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void getMaxNumber() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("numbers","1,2,3,4,5");
        params.add("quantifier","2");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/max").params(params))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void getAvgNumber() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("numbers","1,2,3,4,5");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/avg").params(params))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void getMedianNumber() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("numbers","1,2,3,4,5");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/median").params(params))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void getQthPercentile() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("numbers","1,2,3,4,5");
        params.add("quantifier","0.3");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/percentile").params(params))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}