package com.cp.crud.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "parent")
@Data
public class Parent {

	@Id
	@GeneratedValue
	@Column(name = "pid")
	private Integer parentId;

	@Column(name = "pCode")
	private String parentCode;

	@Column(name = "mName")
	private String motherName;

	@Column(name = "fName")
	private String fatherName;

	@Column(name = "surname")
	private String surname;

	@Column(name = "foccupation")
	private String fatherOccupation;
}
