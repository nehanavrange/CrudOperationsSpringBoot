package com.cp.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cp.crud.domain.Employee;
import com.cp.crud.request.EmployeeRequest;
import com.cp.crud.service.IEmployeeService;

@RestController
@RequestMapping(value = { "/api" })
public class EmployeeController {

	@Autowired
	IEmployeeService service;

	@PostMapping("/save")
	public ResponseEntity<?> saveEmployee(@RequestBody EmployeeRequest employeeRequest) {
		Employee employee = service.addEmp(employeeRequest);
		if (employee != null) {
			return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Employee>(employee, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<EmployeeRequest>> getAllEmployee() {
		List<EmployeeRequest> employeeRequestList = service.getAllEmp();
		return new ResponseEntity<List<EmployeeRequest>>(employeeRequestList, HttpStatus.OK);
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<EmployeeRequest> getEmployeeById(@PathVariable("id") Integer id) {
		EmployeeRequest employeeRequest = service.getEmpById(id);
		return new ResponseEntity<EmployeeRequest>(employeeRequest, HttpStatus.OK);
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
		Boolean flag = service.deleteById(id);
		if (flag) {
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<Employee> update(@RequestBody EmployeeRequest employeeRequest) {
		Employee employee = service.addEmp(employeeRequest);
		if (employee != null) {
			return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Employee>(employee, HttpStatus.BAD_REQUEST);
		}
	}
}
