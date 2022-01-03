package com.cp.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cp.crud.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}