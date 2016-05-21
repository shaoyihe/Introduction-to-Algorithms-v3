package c10.s01.t07;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackTest {
	Stack stack=new Stack(10);
	
	@Test
	public void test() throws Exception {
		stack.push(10);
		stack.push(20);
		stack.push(30);
		assertEquals(false, stack.isEmpty());
		assertEquals(3, stack.size());
		assertEquals(30, stack.pop());
		assertEquals(20, stack.pop());
		assertEquals(10, stack.pop());
		assertEquals(0, stack.size());
		assertEquals(true, stack.isEmpty());
	}

}
