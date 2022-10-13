package com.valtech.training.valtech.Junit5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class AirthmaticTest {
	private Airthmatic airthmatic;
	private static int ZERO;
	
	
	
	@Nested
	public class DivisionTest{
		private Airthmatic  airthmatic;
		@Test
		public void testDivByZero(){
			airthmatic=new Airthmaticimpl();
			assertThrows(ArithmeticException.class, ()->{airthmatic.div(2, ZERO);});
		}
	}
	
	@Nested
	@DisplayName("This is only for Testing Sub Method of the Airthmatic")
	public  class SubtractionTest{
		
		
		
		private Airthmatic airthmatic;
		@ParameterizedTest
		@CsvSource({
			"'Subtracting 2 Positive Nos',2,3,-1",
			"'Substracting 2 Negative Nos',-2,-3,1",
			"'Subtracting 1 Positive 1 Negative No',-2,3,-5",
		})
		public void testSub(String name,int a,int b,int res){
			airthmatic =new Airthmaticimpl();
			assertEquals(res, airthmatic.sub(a, b));
		}
	}

	@DisplayName("{index} {0} {1}+{2}={3}")
	@ParameterizedTest
	@CsvSource({
		"'Adding 2 Positive Nos',2,3,5",
		"'Adding 2 Negative Nos',-2,-3,-5",
		"'Adding 1 Positive 1 Negative No',-2,3,1",
	})
	public void testAdd(String name,int a,int b,int res){
		assertEquals(res, airthmatic.add(a, b));
	}
	
	public static Stream<Arguments> argumentsForAdd(){
		return Stream.of(Arguments.of(2,3,5),Arguments.of(1,3,4));
	}
	
	@ParameterizedTest
	@DisplayName("{index} Testing for add with {0} and {1} should be equal {2}")
	@MethodSource("argumentsForAdd")
	public void teatAdd(int a,int b,int res){
		
	}

	@Test
	@DisplayName("Generic Test Cases for Add...")
	public void testAdd() {
		airthmatic = new Airthmaticimpl();
		assertEquals(5, airthmatic.add(2, 3));
		assertEquals(5, airthmatic.add(3, 2));

	}

	@ParameterizedTest
	@ValueSource(ints = { 2, 3, 4, -1, -2 })
	@DisplayName(value="{index} Testing for add with {0} and 0")
	public void testAdd(int a) {

		assertEquals(a, airthmatic.add(a, 0));
	}

	@BeforeAll
	public static void executeMeFirst() {
		System.out.println("Before All -executed First");
		ZERO = 0;
	}

	@AfterAll
	public static void executeMeJustBeforeProgramExists() {
		System.out.println("last method to be executed");
	}

	@BeforeEach
	public void runBefore() {
		airthmatic = new Airthmaticimpl();
		System.out.println("Run Befoe....");
	}

	@AfterEach
	public void afterTest() {
		System.out.println("Run after method");
	}

	@Test
	public void testHi() {
		System.out.println("hi..");
	}

	@Test
	public void testHello() {
		System.out.println("Hello...");
	}
}
