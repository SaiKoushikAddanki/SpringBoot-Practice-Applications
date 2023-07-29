package com.epam.practice.service;

import java.util.Random;
import java.util.concurrent.Callable;

public class RandomNumCallable implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		
		return new Random().nextInt();
	}

}
 