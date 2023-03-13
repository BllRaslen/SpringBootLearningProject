package com.bilal.springbootproject.repository;

import com.bilal.springbootproject.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department findByDepartmentName(String department);

    @Query(value ="SELECT * FROM department WHERE department.department_id = ?" , nativeQuery = true )
    public Department findByDepartmentNameIgnoreCase(String department);

}
