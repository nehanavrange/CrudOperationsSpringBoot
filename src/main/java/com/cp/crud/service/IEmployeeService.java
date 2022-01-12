package com.cp.crud.service;

import java.util.List;

import com.cp.crud.domain.Employee;
import com.cp.crud.request.EmployeeRequest;

public interface IEmployeeService {

	Employee addEmp(EmployeeRequest emp);

	List<EmployeeRequest> getAllEmp();

	EmployeeRequest getEmpById(Integer id);

	Boolean deleteById(Integer id);

}
