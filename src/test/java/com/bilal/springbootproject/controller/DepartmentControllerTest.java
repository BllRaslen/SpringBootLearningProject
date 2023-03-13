package com.bilal.springbootproject.controller;

import com.bilal.springbootproject.entity.Department;
import com.bilal.springbootproject.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;


    @BeforeEach
    void setUp() {

        department = Department.builder()
                .departmentAddress("TR")
                .departmentCode("CS-001")
                .departmentName("CS")
                .departmentId(1L).build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentName("CS")
                .departmentAddress("TR")
                .departmentCode("CS-001")
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment))
        .thenReturn((department));

        mockMvc.perform(post("/departments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"departmentName\": \"CS\",\n" +
                                "    \"departmentAddress\": \"TR\",\n" +
                                "    \"departmentCode\": \"CS-001\"\n" +
                                "}"))
                .andExpect(status().isOk());
    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L))
                .thenReturn(department);

        mockMvc.perform(get("/departments/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName").
                        value(department.getDepartmentName()));
    }
}
