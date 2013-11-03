package c12.s01.t04;

import static org.junit.Assert.*;

import org.junit.Test;

public class TreeTest {
	Tree tree=new Tree();
	
	@Test
	public void test() {
		System.err.println(tree.binarySearchTree.breadthFirst());
//		System.err.println(tree.preOrderTreeWalk());
//		System.err.println(tree.preorderTreeWalkLoop());
		
		System.err.println(tree.postOrderTreeWalk());
	}

}
