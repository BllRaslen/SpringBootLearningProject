package com.bilal.springbootproject.controller;


import com.bilal.springbootproject.entity.Department;
import com.bilal.springbootproject.error.DepartmentNotFoundException;
import com.bilal.springbootproject.repository.DepartmentRepository;
import com.bilal.springbootproject.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> all() {
        // return departmentRepository.findAll();
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {

            return departmentService.fetchDepartmentById(departmentId);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.fetchDepartmentByName(departmentName);

    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {

        departmentService.deleteDepartmentById(departmentId);
        return "Deleted Department!";
    }

    @PutMapping("/departments/{id}")
    public Department updatedepartment(@PathVariable("id") Long departmentId ,
                                       @RequestBody Department department
    ){

        return departmentService.updatedepartment(departmentId , department);
    }

}
