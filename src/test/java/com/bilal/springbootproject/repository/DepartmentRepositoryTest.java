package com.bilal.springbootproject.repository;

import com.bilal.springbootproject.entity.Department;
import org.checkerframework.common.util.report.qual.ReportUse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;


    @BeforeEach
    void setUp() {

        Department department =
        Department.builder()
                .departmentName("ML")
                .departmentAddress("TURKEY")
                .departmentCode("ML-0054")
                .build();
        testEntityManager.persist(department);
    }
    @Test
    public void whenFindById_thenReturnDepartment(){
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName() , "ML");
    }


}