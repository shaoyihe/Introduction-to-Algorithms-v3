package c10.s02.others.links_with_sentinel;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {
	LinkedList<Integer> list=new LinkedList<Integer>();
	
	@Test
	public void test() {
		assertEquals("[]", list.toString());
		assertTrue(list.isEmpty());
		
		list.insert(10);
		list.insert(20);
		list.insert(30);
		
		assertFalse(list.isEmpty());
		assertEquals("[30,20,10]", list.toString());
		assertEquals(3, list.size());
		assertEquals(0, list.search(30));
		assertEquals(2, list.search(10));
		
		assertTrue(list.delete(20));
		assertEquals("[30,10]", list.toString());
		assertTrue(list.delete(10));
		assertTrue(list.delete(30));
		
		assertEquals("[]", list.toString());
		assertTrue(list.isEmpty());
	}

}
