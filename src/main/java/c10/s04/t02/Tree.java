package c10.s04.t02;

import static c10.s04.util.Util.*;

public class Tree {
  
	public static void outputTree() {
		BinaryTree binaryTree=BinaryTree.build(5);
		outputTreeInner(0,binaryTree.root);
	}
	
	private static void outputTreeInner(int height,BinaryTree.Node node) {
		if (node!=null) {
			outputTreeInner(height+1, node.left);
			System.err.println("height:"+height+",element:"+node.element);
			outputTreeInner(height+1, node.right);
		}
	}
	
	public static void main(String[] args) {
		outputTree();
	}

}
