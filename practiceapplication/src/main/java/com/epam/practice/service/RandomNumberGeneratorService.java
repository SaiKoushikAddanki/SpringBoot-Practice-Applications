package com.epam.practice.service;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RandomNumberGeneratorService extends Thread implements Runnable {

	//volatile int count;
	int count;
	Lock lock = new ReentrantLock(); 

	@Override
	public void run() {
		lock.lock();
		count++;
		System.out.println(count);
		System.out.println("Random number is" + new Random().nextInt());
		lock.unlock();
	}

}
