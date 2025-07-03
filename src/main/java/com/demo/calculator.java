package com.demo;

public class calculator {

	public int add (int a, int b) {
		return a+b;
	}
	
	public int substract (int a, int b) {
		return a-b;
	}
	
	public int div(int a, int b) {
		if(b==0) {
			throw new ArithmeticException();
		}
		return a/b;
	}
	
	public int multiply (int a, int b) {
		return a*b;
	}
	
	public int mod(int a, int b) {
		return a%b;
	}
}
