package c10.s02.t02;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackTest {
	Stack<Integer> stack=new Stack<Integer>();
	
	@Test
	public void test() {
		stack.push(10);
		assertEquals(false, stack.isEmpty());
		stack.push(20);
		stack.push(30);
		stack.push(40);
		assertEquals(4, stack.size());
		assertEquals(40, stack.pop());
		assertEquals(30, stack.pop());
		assertEquals(20, stack.pop());
		assertEquals(10, stack.pop());
		assertEquals(true, stack.isEmpty());
	}

}
