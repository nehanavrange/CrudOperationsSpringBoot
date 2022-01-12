package com.cp.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cp.crud.domain.Parent;
import com.cp.crud.request.EmployeeRequest;
import com.cp.crud.request.ParentRequest;
import com.cp.crud.service.IParentService;

@RestController
@RequestMapping(value = { "/parent" })
public class ParentController {

	@Autowired
	IParentService service;

	@PostMapping("/save")
	public ResponseEntity<?> saveParent(@RequestBody ParentRequest parentRequest) {
		Parent parent = service.addParent(parentRequest);
		if (parent != null) {
			return new ResponseEntity<Parent>(parent, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Parent>(parent, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<EmployeeRequest>> getAllEmployee() {
		return null;
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<EmployeeRequest> getEmployeeById(@PathVariable("id") Integer id) {
		return null;
	}
}
