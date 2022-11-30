package com.simplon.macnss.controller;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class RegisterControllerTest {
//    private MockMvc mockMvc;
//    @Test
//    void register() throws  Exception {
//        this.mockMvc.perform(post("/register")
//                        .param("username", "John")
//                        .param("password", "Doe")
//                        .param("email", "JohnD@gmail.com"))
//                .andExpect(view().name("index"))
//                .andExpect(status().isOk())
//                .andDo(print());
//    }


    @Test
    public void givenSaveBasicInfoStep1_whenCorrectInput_thenSuccess() throws Exception {

    }
}