package com.cp.crud.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Employee_tab")
@Data
public class Employee {


	@Id
	@GeneratedValue
	@Column(name = "empId")
	private Integer employeeId;

	@Column(name = "empName")
	private String employeeName;

	@Column(name = "empSalary")
	private Double employeeSalary;



}
