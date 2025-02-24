package com.trivium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class MyCalculatorTest {

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

	@ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void testAddWithMultipleValues(int input) {
      
       
        assertEquals(input + 5, c.add(input, 5));  
    }
	@Test
	void testAdd() {

		assertEquals(5, c.add(2, 3));
	}

	@Test
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
	
	static Stream<org.junit.jupiter.params.provider.Arguments> inputForAddition() {
	    return Stream.of(
	        org.junit.jupiter.params.provider.Arguments.of(1, 5, 6),
	        org.junit.jupiter.params.provider.Arguments.of(2, 3, 5),
	        org.junit.jupiter.params.provider.Arguments.of(10, 20, 30),
	        org.junit.jupiter.params.provider.Arguments.of(0, 0, 0)
	    );

	}
	
	@ParameterizedTest
	@MethodSource("inputForAddition")
	void testAddWithMethodSource(int a, int b, int expected) {
	    Calculator c = new Calculator();
	   
	    assertEquals(expected, c.add(a, b));  
	}


}
