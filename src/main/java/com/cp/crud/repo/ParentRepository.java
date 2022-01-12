package com.cp.crud.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cp.crud.domain.Parent;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Integer> {
	Optional<Parent> findByParentId(Integer id);
	Optional<Parent> findByParentCode(String code);
}
