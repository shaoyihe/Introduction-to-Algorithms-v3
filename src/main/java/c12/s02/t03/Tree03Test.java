package c12.s02.t03;

import static org.junit.Assert.*;

import org.junit.Test;

import c12.s02.t02.Tree;

public class Tree03Test {
	Tree tree=new Tree();
	@Test
	public void test() {
		System.err.println(tree.binarySearchTree.breadthFirst());
		System.err.println(tree.predecessorNode(tree.binarySearchTree.root).element);
	}

}
