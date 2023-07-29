package com.epam.practice.lsp;

public class SmartPhone extends Mobile implements Mp3Player{

	@Override
	public void sendSMS() {
		System.out.println("sending sms..");
		
	}

	@Override
	public void call() {
		System.out.println("calling");
		
	}

	@Override
	public void playMusic(String fileName) {
		System.out.println("Playing music "+fileName);
		
	}

	@Override
	public void playVideo(String videoFileName) {
		System.out.println("Playing video "+videoFileName);
		
	}

}

