package c10.s01.t02;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


public class StackDoubleTest  {
	private StackDouble stackDouble;
	
	@Before
	public void init(){
		stackDouble=new StackDouble(6);
	}
	
	@Test
	public void testPushPop() throws Exception{
		stackDouble.pushA(10);
		stackDouble.pushA(20);
		stackDouble.pushA(30);
		stackDouble.pushB(10);
		stackDouble.pushB(30);
		stackDouble.pushB(20);
		Assert.assertEquals(30, stackDouble.popA());
		Assert.assertEquals(20, stackDouble.popA());
		Assert.assertEquals(10, stackDouble.popA());
		Assert.assertEquals(20, stackDouble.popB());
		Assert.assertEquals(30, stackDouble.popB());
		Assert.assertEquals(10, stackDouble.popB());
		System.err.println(stackDouble);
	}
}
