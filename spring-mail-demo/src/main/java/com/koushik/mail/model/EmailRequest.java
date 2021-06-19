package com.koushik.mail.model;

import lombok.Data;

@Data
public class EmailRequest {

	private String body;
	private String to;
	private String from;
	private String subject;
}
