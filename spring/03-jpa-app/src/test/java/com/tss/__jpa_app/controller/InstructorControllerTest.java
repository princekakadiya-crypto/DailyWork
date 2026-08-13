package com.tss.__jpa_app.controller;

import com.tss.__jpa_app.dto.InstructorRequestDto;
import com.tss.__jpa_app.dto.InstructorResponseDto;
import com.tss.__jpa_app.service.InstructorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(InstructorController.class)
class InstructorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private InstructorService instructorService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void addInstructorTest() throws Exception{
        InstructorRequestDto request = new InstructorRequestDto();
        request.setInstructorName("Prince");
        request.setDesignation("Software");

        InstructorResponseDto response = new InstructorResponseDto();
        response.setInstructorId(1L);
        response.setInstructorName("Prince");
        response.setDesignation("Software");

        when(instructorService.addInstructor(any(InstructorRequestDto.class)))
                .thenReturn(response);

        mockMvc.perform(post("/app/instructors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.instructorId").value(1))
                .andExpect(jsonPath("$.instructorName").value("Prince"))
                .andExpect(jsonPath("$.designation").value("Software"));

        verify(instructorService, times(1))
                .addInstructor(any(InstructorRequestDto.class));
    }
}