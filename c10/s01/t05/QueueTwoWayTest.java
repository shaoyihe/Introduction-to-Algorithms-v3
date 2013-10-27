package c10.s01.t05;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTwoWayTest {
	QueueTwoWay queueTwoWay=new QueueTwoWay(6);
	
	@Test
	public void test() throws Exception {
		queueTwoWay.enQueueToHead(10);
		queueTwoWay.enQueueToHead(20);
		System.err.println(queueTwoWay);
		assertEquals(10, queueTwoWay.deQueueFromTail());
		assertEquals(20, queueTwoWay.deQueueFromTail());
		assertTrue(queueTwoWay.isEmpty());
	
		
		queueTwoWay.enQueue(10);
		queueTwoWay.enQueue(20);
		System.err.println(queueTwoWay);
		assertEquals(10, queueTwoWay.deQueue());
		assertEquals(20, queueTwoWay.deQueue());
		assertTrue(queueTwoWay.isEmpty());
		System.err.println(queueTwoWay);
	}

}
