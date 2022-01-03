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
import com.cp.crud.service.IEmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	IEmployeeService service;

	@PostMapping("/save")
	public ResponseEntity<?> saveAll(@RequestBody Employee emp) {
		Employee e = service.addEmp(emp);
		return new ResponseEntity<Employee>(e, HttpStatus.CREATED);
	}

	@GetMapping("/getall")
	public ResponseEntity<List<Employee>> getAllEmp() {
		List<Employee> list = service.getAllEmp();
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);

	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<Employee> getAllEmp(@PathVariable("id") Integer id) {
		Employee emp = service.getEmpById(id);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {
		service.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);

	}

	@PutMapping("/update")
	public ResponseEntity<Employee> update(@RequestBody Employee emp) {
		Employee e = service.addEmp(emp);
		return new ResponseEntity<Employee>(e, HttpStatus.CREATED);

	}

}
