package com.cp.crud.request;

import lombok.Data;

@Data
public class StudParentRequest {

	private Integer studentId;

	private String studentName;

	private String course;

	private Double fees;

	private String parentCode;

	private String motherName;

	private String fatherName;

	private String surname;

	private String fatherOccupation;
}
