package com.erkantek;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemo {

	@BeforeClass
	public void setUpMethod() {
		System.out.println("Runs once before everything in this class");
	}
	@AfterClass
	public void tearDownClass() {
		System.out.println("Runs after everything in this class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Runs before every method");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("Runs After every Method");
	}
	@Test
	public void tearDownMethod() {
		
		System.out.println("First One");
	}
	@Test
	public void testTwo() {
		System.out.println("Secon One");
	}
	@Test
	public void thirdOne() {
		System.out.println("Third One");
	}
	
	
	
	
	
	
	
}
