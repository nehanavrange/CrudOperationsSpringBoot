package com.cp.crud.response;

import lombok.Data;

@Data
public class StudParentResponse {

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
