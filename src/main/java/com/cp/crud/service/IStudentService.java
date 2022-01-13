package com.cp.crud.service;

import java.util.List;

import com.cp.crud.domain.Student;
import com.cp.crud.request.StudParentRequest;
import com.cp.crud.response.StudParentResponse;

public interface IStudentService {

	Student addStud(StudParentRequest studParentRequest);

	List<StudParentResponse> getAllStudParentInfo();

	StudParentResponse getStudParenInfoById(Integer id);
}
