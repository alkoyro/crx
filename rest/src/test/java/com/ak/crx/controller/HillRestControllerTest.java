package com.ak.crx.controller;

import com.ak.crx.HillApp;
import com.ak.crx.model.HillRequest;
import com.ak.crx.model.HillResponse;
import com.ak.crx.model.converter.HillConverter;
import com.ak.crx.service.HillVolumeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * all in-place test (more or less it's like an integration one)
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HillApp.class)
@WebAppConfiguration
public class HillRestControllerTest {

    private MockMvc mvc;

    @Autowired
    private HillVolumeService hillVolumeService;

    @Autowired
    private HillConverter hillConverter;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        this.mvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void calculateVolumeSuccess() throws Exception {
        //given
        HillRequest hillRequest = new HillRequest();
        hillRequest.setSurfacePoints(Arrays.asList("10", "0", "10"));
        String contentBody = new ObjectMapper().writeValueAsString(hillRequest);

        //when
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/hills/volume")
                .accept(MediaType.APPLICATION_JSON)
                .content(contentBody)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        //then
        String response = mvcResult.getResponse().getContentAsString();
        HillResponse hillResponse = new ObjectMapper().readValue(response, HillResponse.class);
        Assert.assertTrue(10 == hillResponse.getVolume());
    }
}
