package com.epam.practice.lsp;

public class Ipod implements Mp3Player {


	@Override
	public void playMusic(String fileName) {
		System.out.println("Playing music "+fileName);
		
	}

}
