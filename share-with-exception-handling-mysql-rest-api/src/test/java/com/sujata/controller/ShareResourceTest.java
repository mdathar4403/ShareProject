package com.sujata.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sujata.entity.Share;
import com.sujata.service.ShareService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.springframework.http.MediaType;

@WebMvcTest
@ContextConfiguration(classes = ShareResource.class)
class ShareResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    ShareService shareService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllDetails() throws Exception {

        ArrayList<Share> shares=new ArrayList<>();
        shares.add(new Share());
        shares.add(new Share());
        shares.add(new Share());

        //Mocking the behaviour of Service method
        given(shareService.getAllShares()).willReturn(shares);

        ResultActions response=mockMvc.perform(get("/shares"));

        response.andExpect(status().isOk())
                .andExpect(jsonPath("$.size()",
                        is(shares.size())));

    }

    @Test
    void saveRecord() throws Exception {

        Share share=new Share(1,"AAAA",1500, LocalDate.now());

        given(shareService.insertShare(share)).willReturn(true);

        ResultActions response = mockMvc.perform(post("/shares")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(share)));

        response.andDo(print()).
                andExpect(status().isCreated());

    }

    @Test
    void getRecordById() throws Exception {

        Share share=new Share(1,"AAAA",1500, LocalDate.now());

        given(shareService.getShareById(1)).willReturn(share);

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/shares/{id}", 1));

        response.andExpect(status().isOk())
                .andExpect(jsonPath("$.shareId", is(share.getShareId())))
                .andExpect(jsonPath("$.shareName", is(share.getShareName())))
                .andExpect(jsonPath("$.market_price", is(share.getMarket_price())));

    }

    @Test
    void deleteRecord() {
    }

    @Test
    void updateRecord() {
    }
}