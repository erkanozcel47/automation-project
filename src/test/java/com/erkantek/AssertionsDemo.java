package com.erkantek;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsDemo {

	@Test
	public void testOne() {
		System.out.println("Asserting first");
		Assert.assertTrue(false);
		System.out.println("done Asserting first");
	}
	// Assertion in the method actually the one which doing the testing.
	// They are used to verify data
	@Test
	public void testTwo() {
		System.out.println("Asserting secon");
		Assert.assertTrue(true);
		System.out.println("done Asserting secon");
	}
}
