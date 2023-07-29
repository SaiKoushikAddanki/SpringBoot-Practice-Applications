package com.epam.practice.ocp;

public class PhoneNotificationService implements NotificationService {

	private Long phone;
	public PhoneNotificationService(Long phone) {
		this.phone = phone;
	}

	@Override
	public void sendOTP() {
		Long sendTo = this.phone;
		// logic to send the phone number OTP

	}

}
