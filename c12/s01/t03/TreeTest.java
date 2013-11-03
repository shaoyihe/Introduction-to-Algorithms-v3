package c12.s01.t03;

import static org.junit.Assert.*;

import org.junit.Test;

public class TreeTest {
	Tree tree=new Tree();
	
	@Test
	public void test() {
		assertEquals(tree.inorderTreeWalkRecursion(), tree.inorderTreeWalkLoop());
		assertEquals(tree.inorderTreeWalkLoopNotStack(), tree.inorderTreeWalkLoop());
	}

}
