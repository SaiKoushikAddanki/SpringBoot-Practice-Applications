package com.epam.practice.ocp;

import lombok.Getter;

@Getter
public class EmailNotificationService implements NotificationService {
	
	private String email;
	public EmailNotificationService(String email) {
		this.email = email;
	}

	@Override
	public void sendOTP() {
		String sender = this.email;
		//provide the implementaion based on the Email sending logic
		
	}
	
	

}
