package com.kuzmin.evgenii.sberbanktaskspringsecurity.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuzmin.evgenii.sberbanktaskspringsecurity.entity.UserEntity;
import com.kuzmin.evgenii.sberbanktaskspringsecurity.repository.UserRepo;
import com.kuzmin.evgenii.sberbanktaskspringsecurity.rest.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
class MainControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserRepo userRepo;

    @Test
    void loginWithoutCredentials() throws Exception {
        mockMvc.perform(post("/auth/login")
                .param("login", "")
                .param("password", "")).andExpect(mvcResult ->
        {
            ObjectMapper mapper = new ObjectMapper();
            Response response = mapper.readValue(mvcResult.getResponse().getContentAsString(), Response.class);
            Assertions.assertNotNull(response.getErrorResponse());
        });
    }

    @Test
    void loginWithWrongCredentials() throws Exception {
        mockMvc.perform(post("/auth/login")
                .param("login", "sa")
                .param("password", "sa")).andExpect(mvcResult ->
        {
            ObjectMapper mapper = new ObjectMapper();
            Response response = mapper.readValue(mvcResult.getResponse().getContentAsString(), Response.class);
            Assertions.assertNotNull(response.getErrorResponse());
        });
    }

    @Test
    void loginWithValidCredentials() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setLogin("admin");
        userEntity.setPasswordHash(DigestUtils.md5DigestAsHex("admin".getBytes()));
        userRepo.save(userEntity);
        mockMvc.perform(post("/auth/login")
                .param("login", "admin")
                .param("password", "admin")).andExpect(mvcResult ->
        {
            ObjectMapper mapper = new ObjectMapper();
            Response response = mapper.readValue(mvcResult.getResponse().getContentAsString(), Response.class);
            Assertions.assertNotNull(response.getResult());
        });
    }
}