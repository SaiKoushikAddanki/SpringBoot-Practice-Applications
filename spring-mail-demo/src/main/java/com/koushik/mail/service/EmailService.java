package com.koushik.mail.service;

import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.koushik.mail.model.EmailRequest;
import com.koushik.mail.model.EmailResponse;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	public EmailResponse send(EmailRequest request) {
		EmailResponse response = new EmailResponse();
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());
			helper.setTo(request.getTo());
			helper.setFrom(request.getFrom());
			helper.setSubject(request.getSubject());
			helper.setText(request.getBody());
			mailSender.send(message);
			
			response.setMessage("Email was delivered successfully to:" + request.getTo());
			response.setStatus(true);
		} catch (MessagingException e) {
			response.setMessage("Email was not delivered due to some external issue");
			response.setStatus(false);
			e.printStackTrace();
		}
		return response;

	}
}
