package com.bilal.springbootproject.service;

import com.bilal.springbootproject.entity.Department;
import com.bilal.springbootproject.repository.DepartmentRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {


    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    //@BeforeAll
    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentId(1L)
                        .departmentName("IT")
                        .departmentAddress("Ahmadabad")
                        .departmentCode("IT-054")
                        .build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);
    }
    @Test
    @DisplayName("Get Data ")
    @Disabled
    public void whenValidDepartmentName_thenDepartmentShouldSound(){

        String departmentName = "I8T";
        Department found = departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName , found.getDepartmentName());
    }
}