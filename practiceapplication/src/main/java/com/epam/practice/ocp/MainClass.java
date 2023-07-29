package com.epam.practice.ocp;

import org.springframework.beans.factory.annotation.Autowired;

public class MainClass {

	@Autowired
	NotificationService notificationService;
	
	public void performNotification(NotificationService notificationService) {
		notificationService.sendOTP();
	}
	
	public static void main(String[] args) {
		MainClass mainClass = new MainClass();
		mainClass.performNotification(new EmailNotificationService("sai@epam.com"));
		mainClass.performNotification(new PhoneNotificationService(8465046879L));
		System.out.println(10/0);
	}
}
