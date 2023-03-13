package com.bilal.springbootproject.service;

import com.bilal.springbootproject.entity.Department;
import com.bilal.springbootproject.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {


    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();


    public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

    public Department updatedepartment(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);

}

