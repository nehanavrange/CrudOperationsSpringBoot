package com.cp.crud.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.crud.domain.Employee;
import com.cp.crud.repo.EmployeeRepository;
import com.cp.crud.request.EmployeeRequest;
import com.cp.crud.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	EmployeeRepository repository;

	@Override
	public Employee addEmp(EmployeeRequest employeeRequest) {

		Optional<Employee> optional = repository.findByEmployeeId(employeeRequest.getEmployeeId());
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			employee = new Employee();
		}
		BeanUtils.copyProperties(employeeRequest, employee);
		return repository.save(employee);
	}

	@Override
	public List<EmployeeRequest> getAllEmp() {
		List<Employee> employeeList = repository.findAll();
		List<EmployeeRequest> employeeRequestes = new ArrayList<>();

		for (Employee emp : employeeList) {

			BeanUtils.copyProperties(emp, employeeRequestes);
		}
		return employeeRequestes;
	}

	@Override
	public EmployeeRequest getEmpById(Integer id) {
		Optional<Employee> optional = repository.findById(id);
		EmployeeRequest employeeRequest = new EmployeeRequest();
		if (optional.isPresent()) {
			Employee employee = optional.get();
			BeanUtils.copyProperties(employee, employeeRequest);
		}
		return employeeRequest;
	}

	@Override
	public Boolean deleteById(Integer id) {
		Boolean flag = false;
		if (id != null) {
			repository.deleteById(id);
			flag = true;
		}
		return flag;
	}

}
