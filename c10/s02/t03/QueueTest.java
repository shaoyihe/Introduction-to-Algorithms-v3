package c10.s02.t03;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTest {
	Queue<Integer> queue=new Queue<Integer>();
	@Test
	public void test() {
		queue.enQueue(10);
		queue.enQueue(20);
		queue.enQueue(30);
		queue.enQueue(40);
		assertEquals(4, queue.size());
		assertEquals(10, queue.deQueue());
		assertEquals(20, queue.deQueue());
		assertEquals(30, queue.deQueue());
		assertEquals(40, queue.deQueue());
		assertEquals(null, queue.deQueue());
		assertEquals(true, queue.isEmpty());
		
	}

}
