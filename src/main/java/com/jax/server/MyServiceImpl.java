package com.jax.server;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

@Service("myService")
@WebService
public class MyServiceImpl implements IMyService {
	public int add(int a, int b) {
		return a + b;
	}

	public int minus(int a, int b) {
		return a - b;
	}
}