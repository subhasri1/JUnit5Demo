package com.trivium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class CalculatorTest {
	static Calculator c =null;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		c= new Calculator();
		System.out.println("setUpBeforeClass()");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		c= null;
		System.out.println("tearDownAfterClass()");
	}

	@BeforeEach
	void setUp() throws Exception {
		//	c= new Calculator();
		System.out.println("setUp()");
	}

	@AfterEach
	void tearDown() throws Exception {
		//c=null;
		System.out.println("tearDown()");
	}

	@Test
	void testAdd() {

		assertEquals(5, c.add(2, 3));
	}

	@Test
	@Timeout(1)
	//@Disabled
	void testDifference() {
		assertEquals(-1, c.difference(2, 3));
	}
	@Test
	void testDivideException() {
		Exception exception = assertThrows(ArithmeticException.class, 
				() -> {
					c.divide(5,0);
				});
		String expectedMessage = "/ by zero";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
	@Test
	void testDivide() {
		assertEquals(2, c.divide(8,4));
	}
	
	
}
