package com.cp.crud.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.crud.domain.Employee;
import com.cp.crud.repo.EmployeeRepository;
import com.cp.crud.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	EmployeeRepository repository;

	@Override
	public Employee addEmp(Employee emp) {

		return repository.save(emp);
	}

	@Override
	public List<Employee> getAllEmp() {
		List<Employee> list = repository.findAll();
		return list;
	}

	@Override
	public Employee getEmpById(Integer id) {

		return repository.findById(id).get();
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);

	}

}
