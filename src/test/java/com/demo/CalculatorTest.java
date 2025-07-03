package com.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

@TestInstance(Lifecycle.PER_CLASS) // this will create 1 object of test class. if we
                                   //don't give this it will create object of the test class for all the @test methods
class CalculatorTest {

	static calculator c1;
	
	CalculatorTest(){
		System.out.println("caculatorTest() object created......");
	}
	
	@BeforeAll
	static void createObject() {
		c1= new calculator();
	}
	
	@AfterAll
	static void removeObject() {
		c1=null;
	}
	
	@BeforeEach
	void abc() {
		System.out.println("<------before each test case------>");
	}
	
	@AfterEach
	void xyz() {
		System.out.println("<------after each test case------>");
	}
	
	@Test
	void testAdd() {
		int actual = c1.add(10, 30);
		int expected = 40;
		assertEquals(expected,actual);
		System.out.println("test()");
	}

	@Test
	@Disabled  // if we want to skip any test case
	void testDiv() {
		assertThrows(ArithmeticException.class,()->c1.div(10, 0));
		System.out.println("testDiv()");
	}
	
	@Test
	void testMul() {
		assertEquals(10,c1.multiply(5, 2));
		// if there are multiple assertion and it will fail if
		//1 assertion fail so to keep it running we will keep all assetion under assertall
//		assertAll(
//				()->assertEquals(10,c1.multiply(10, 0)),
//				()->assertEquals(20,c1.multiply(4, 5)),
//				()->assertEquals(30,c1.multiply(15, 3))
//				);
		System.out.println("testMul()");
	}
	
	@Test
	void testMod() {
		assertEquals(0,c1.mod(8, 2));
		System.out.println("testMod()");
	}
	
	@Test
	@EnabledOnOs(OS.WINDOWS) // it will only run for windows os
	void testDLL() {
		System.out.println("testDLL()");
	}
	
	@Test
	@EnabledOnOs(value= {OS.LINUX,OS.MAC,OS.SOLARIS})
	void testShell() {
		System.out.println("testShell()");
	}
	
	@Test
	//@EnabledOnJre(JRE.JAVA_8) for java 8
	@EnabledForJreRange(min=JRE.JAVA_8, max=JRE.JAVA_14) // if the jre range is between 8-14
	void testLambda() {
		System.out.println("testLambda()");	
	}
	
}
