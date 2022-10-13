package com.valtech.learning.maven.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArithmaticImplTest {

	@Test
	public void addtest() {
		Arithmetic a=new ArithmaticImpl();
		assertEquals(5, a.add(2, 3));
		assertEquals(5, a.add(3, 2));
		assertEquals(3, a.add(0, 3));
		assertEquals(3, a.add(3, 0));
		assertEquals(5, a.add(-2, 7));
		assertEquals(5, a.add(7, -2));
		assertEquals(0, a.add(0, 0));
	}
	@Test
	public void subtest() {
		// TODO Auto-generated method stub
		Arithmetic a=new ArithmaticImpl();
		assertEquals(5, a.sub(7, 2));
		assertEquals(6, a.sub(9, 3));
		assertEquals(10, a.sub(14, 4));
	}
	@Test
	public void multest() {
		// TODO Auto-generated method stub
		Arithmetic a=new ArithmaticImpl();
		assertEquals(6, a.mul(3, 2));
		assertEquals(9, a.mul(3, 3));
		assertEquals(10, a.mul(5, 2));

	}
	@Test
	public void divtest() {
		// TODO Auto-generated method stub
		Arithmetic a=new ArithmaticImpl();
		assertEquals(5, a.div(20, 4));
		assertEquals(5, a.div(25, 5));
		assertEquals(10, a.div(100, 10));
		try {
			a.div(3, 0);
			fail("ArithmaticException was wxpected with '/by zero");
		}catch(ArithmeticException ae){
			
		}
	}
}
