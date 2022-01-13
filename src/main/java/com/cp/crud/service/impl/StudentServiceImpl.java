package com.cp.crud.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.crud.domain.Parent;
import com.cp.crud.domain.Student;
import com.cp.crud.repo.ParentRepository;
import com.cp.crud.repo.StudentRepository;
import com.cp.crud.request.StudParentRequest;
import com.cp.crud.response.StudParentResponse;
import com.cp.crud.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	StudentRepository stdRepository;

	@Autowired
	ParentRepository parentRepository;

	@Override
	public Student addStud(StudParentRequest studentRequest) {

		Optional<Student> optional = stdRepository.findByStudentId(studentRequest.getStudentId());
		Student student = null;
		if (optional.isPresent()) {
			student = optional.get();
		} else {
			student = new Student();
		}
		Optional<Parent> optional1 = parentRepository.findByParentCode(studentRequest.getParentCode());
		Parent parent = null;
		if (optional.isPresent()) {
			parent = optional1.get();
		} else {
			parent = new Parent();
		}

		BeanUtils.copyProperties(studentRequest, parent);

		// Parent parentDetails = parentRepository.save(parent);
		parentRepository.save(parent);

		BeanUtils.copyProperties(studentRequest, student);
		// student.setParentCode(parentDetails.getParentCode());
		stdRepository.save(student);

		return student;
	}

	@Override
	public List<StudParentResponse> getAllStudParentInfo() {
		List<Student> studentList = stdRepository.findAll();
		List<StudParentResponse> studParentResponseList = new ArrayList<>();
		for (Student student : studentList) {
			StudParentResponse studParentResponse = new StudParentResponse();
			BeanUtils.copyProperties(student, studParentResponse);
			Optional<Parent> parentDetails = parentRepository.findByParentCode(studParentResponse.getParentCode());
			Parent parent = parentDetails.get();
			BeanUtils.copyProperties(parent, studParentResponse);
			studParentResponseList.add(studParentResponse);
		}

		return studParentResponseList;
	}

	@Override
	public StudParentResponse getStudParenInfoById(Integer id) {

		Optional<Student> optional = stdRepository.findById(id);
		StudParentResponse studParentResponse = new StudParentResponse();
		if (optional.isPresent()) {
			Student student = optional.get();
			BeanUtils.copyProperties(student, studParentResponse);
			Optional<Parent> parentDetails = parentRepository.findByParentCode(studParentResponse.getParentCode());
			Parent parent = parentDetails.get();
			BeanUtils.copyProperties(parent, studParentResponse);

		}
		return studParentResponse;
	}

}
