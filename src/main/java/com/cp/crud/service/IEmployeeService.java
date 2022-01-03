package com.cp.crud.service;

import java.util.List;

import com.cp.crud.domain.Employee;

public interface IEmployeeService {

	Employee addEmp(Employee emp);
	List<Employee> getAllEmp();
	Employee getEmpById(Integer id);
	void deleteById(Integer id);

}
