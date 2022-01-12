package com.cp.crud.service.impl;

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
		Optional<Student> optional = stdRepository.findByParentCode(studentRequest.getParentCode());
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
		// student.setParentId(parent.getParentId());
		Parent parentDetails = parentRepository.save(parent);

		BeanUtils.copyProperties(studentRequest, student);
		student.setParentCode(parentDetails.getParentCode());
		stdRepository.save(student);

		return student;
	}

	@Override
	public List<StudParentResponse> getAllStudInfo(StudParentRequest studParentRequest) {
		List<Student> studParentResponseList = stdRepository.findAll();

		return null;
	}

	@Override
	public StudParentRequest getStudById(Integer id) {

		Optional<Student> optional = stdRepository.findById(id);
		StudParentRequest studentRequest = new StudParentRequest();
		if (optional.isPresent()) {
			Student student = optional.get();
			BeanUtils.copyProperties(student, studentRequest);
		}
		return studentRequest;
	}

}
