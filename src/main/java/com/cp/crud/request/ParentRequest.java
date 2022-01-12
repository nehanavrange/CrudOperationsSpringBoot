package com.cp.crud.request;

import lombok.Data;

@Data
public class ParentRequest {

	private Integer parentId;

	private String motherName;

	private String fatherName;

	private String surname;

	private String fatherOccupation;

}
