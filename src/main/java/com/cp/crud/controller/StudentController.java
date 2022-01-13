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

import com.cp.crud.domain.Student;
import com.cp.crud.request.StudParentRequest;
import com.cp.crud.response.StudParentResponse;
import com.cp.crud.service.IStudentService;

@RestController
@RequestMapping(value = { "/std" })
public class StudentController {

	@Autowired
	IStudentService service;

	@PostMapping("/save")
	public ResponseEntity<?> saveStudent(@RequestBody StudParentRequest studentRequest) {
		Student student = service.addStud(studentRequest);
		if (student != null) {
			return new ResponseEntity<Student>(student, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Student>(student, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<StudParentResponse>> getAllStudent() {
		List<StudParentResponse> studParentResponseList = service.getAllStudParentInfo();

		return new ResponseEntity<List<StudParentResponse>>(studParentResponseList, HttpStatus.OK);
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<StudParentResponse> getStudentById(@PathVariable("id") Integer id) {
		StudParentResponse studentResponse = service.getStudParenInfoById(id);
		return new ResponseEntity<StudParentResponse>(studentResponse, HttpStatus.OK);
	}
}
