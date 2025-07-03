package com.demo;

public class calculatorMain {

	public static void main(String[] args) {
		calculator cal = new calculator();
		int sum = cal.add(10, 20);
		System.out.println("total is :" +sum);
		int sub = cal.substract(30, 5);
		System.out.println("result is :" +sub);

	}

}