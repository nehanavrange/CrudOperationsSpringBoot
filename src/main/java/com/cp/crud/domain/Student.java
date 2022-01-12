package com.cp.crud.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue
	@Column(name = "studId")
	private Integer studentId;

	@Column(name = "studName")
	private String studentName;

	@Column(name = "studcourse")
	private String course;

	@Column(name = "studfees")
	private Double fees;

	@Column(name = "pCode")
	private String parentCode;



}











