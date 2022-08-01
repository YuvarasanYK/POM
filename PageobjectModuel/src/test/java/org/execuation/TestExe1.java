package org.execuation;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.utility.BaseClass;

public class TestExe1 extends BaseClass {
	
	//@Test(retryAnalyzer=Retry.class)
	@Test
	public void sample() {
		System.out.println("i am pass");
		Assert.assertTrue(false);
		System.out.println("i am sample");
	}
	
	//@Test(retryAnalyzer=Retry.class)
	@Test
	public void sample2() {
		System.out.println("i am sample2");
		Assert.assertTrue(true);
	}
	
	
}
