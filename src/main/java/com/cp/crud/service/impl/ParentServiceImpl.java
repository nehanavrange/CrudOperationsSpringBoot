package com.cp.crud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.crud.domain.Parent;
import com.cp.crud.repo.ParentRepository;
import com.cp.crud.request.ParentRequest;
import com.cp.crud.service.IParentService;

@Service
public class ParentServiceImpl implements IParentService {

	@Autowired
	ParentRepository repository;

	@Override
	public Parent addParent(ParentRequest parentRequest) {
		Optional<Parent> optional = repository.findByParentId(parentRequest.getParentId());
		Parent parent = null;
		if (optional.isPresent()) {
			parent = optional.get();
		} else {
			parent = new Parent();
		}
		BeanUtils.copyProperties(parentRequest, parent);
		return repository.save(parent);

	}

	@Override
	public ParentRequest getParentById(Integer id) {

		return null;
	}

	@Override
	public List<Parent> getAllParent() {
		// TODO Auto-generated method stub
		return null;
	}
}
