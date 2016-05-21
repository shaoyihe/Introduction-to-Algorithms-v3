package c10.s02.t07;

import org.junit.Test;

import c10.s02.t05.SinglycCircularLinked;

public class SinglycCircularLinkedTest {

	SinglycCircularLinked<Integer> linked=new SinglycCircularLinked<Integer>();
	
	@Test
	public void test() {
		linked.insert(10);
		linked.insert(20);
		linked.insert(30);
		linked.insert(40);
		linked.insert(50);
		
		System.err.println(linked);
		linked.reverse();
		System.err.println(linked);
	}
}
