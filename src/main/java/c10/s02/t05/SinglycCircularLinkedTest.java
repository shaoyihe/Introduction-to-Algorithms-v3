package c10.s02.t05;

import static org.junit.Assert.*;

import org.junit.Test;

public class SinglycCircularLinkedTest {
	SinglycCircularLinked<Integer> linked=new SinglycCircularLinked<Integer>();
	
	@Test
	public void test() {
		linked.insert(10);
		linked.insert(20);
		linked.insert(30);
		assertEquals(0, linked.search(30));
		assertEquals(1, linked.search(20));
		assertEquals(-1, linked.search(0));
		
		assertEquals(true, linked.delete(20));
		assertEquals(false, linked.delete(4));
		assertEquals(1, linked.search(10));
		assertEquals(-1, linked.search(20));
		
		assertEquals(true, linked.delete(10));
		assertEquals(true, linked.delete(30));
		assertEquals(true, linked.isEmpty());
	}

}
