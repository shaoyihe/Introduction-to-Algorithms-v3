package c12.s02.t02;

import static org.junit.Assert.*;

import org.junit.Test;

public class TreeTest {
	Tree tree=new Tree();
	@Test
	public void test() {
		System.err.println(tree.binarySearchTree.breadthFirst());
		System.err.println(tree.minNode().element);
		System.err.println(tree.maxNode().element);
	}

}
