package c10.s02.t06;


import org.junit.Test;

import c10.s02.t05.SinglycCircularLinked;

public class SinglycCircularLinkedTest {
	SinglycCircularLinked<Integer> linked1=new SinglycCircularLinked<Integer>();
	SinglycCircularLinked<Integer> linked2=new SinglycCircularLinked<Integer>();
	
	@Test
	public void test() {
		linked1.insert(10);
		linked1.insert(20);
		linked1.insert(30);
		
		System.err.println(linked1);
		
		linked2.insert(100);
		linked2.insert(200);
		linked2.insert(300);
		
		System.err.println(linked2);
		System.err.println(linked1.union(linked2));
		
	}

}
