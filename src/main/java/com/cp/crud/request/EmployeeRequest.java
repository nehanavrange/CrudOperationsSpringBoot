package com.cp.crud.request;

import lombok.Data;

@Data
public class EmployeeRequest {

	private Integer employeeId;

	private String employeeName;

	private Double employeeSalary;
}
