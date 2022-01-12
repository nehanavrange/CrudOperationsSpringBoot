package com.cp.crud.service;

import java.util.List;

import com.cp.crud.domain.Parent;
import com.cp.crud.request.ParentRequest;

public interface IParentService {

	Parent addParent(ParentRequest parentRequest);

	List<Parent> getAllParent();

	ParentRequest getParentById(Integer id);
}
