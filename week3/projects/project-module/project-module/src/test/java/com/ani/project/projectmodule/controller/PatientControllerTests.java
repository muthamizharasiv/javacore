package com.ani.project.projectmodule.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@ExtendWith(SpringExtension.class)
@WebMvcTest(PatientController.class)
public class PatientControllerTests {
    @Autowired
    private MockMvc mvc;

    @DisplayName("controller: patient controller test")
    @Test
    public void testPatientControllerStatus() throws Exception{
        mvc.perform(
                MockMvcRequestBuilders.get("/patient")
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );
    }
    @DisplayName("controller: test patient object")
    @Test
    public void testPatientControllerObject() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/patient")

        ).andExpect(
                MockMvcResultMatchers.jsonPath(
                        "$.name",
                        Matchers.is("patient")
                )
        );
    }
}

