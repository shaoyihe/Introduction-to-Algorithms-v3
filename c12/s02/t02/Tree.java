package c12.s02.t02;

import c12.s01.other.BinarySearchTree;
import c12.s01.other.BinarySearchTree.Node;

/**12.2-2
 * @author he
 *
 */
public class Tree {
	public BinarySearchTree binarySearchTree=new BinarySearchTree(10);
	
	/**
	 * @return min node recursion
	 */
	public BinarySearchTree.Node minNode() {
		return minNodeInner(binarySearchTree.root);
	}
	
	public BinarySearchTree.Node minNodeInner(Node node) {
		if (node.left!=null) {
			return minNodeInner(node.left);
		}
		return node;
	}
	
	/**  min node recursion
	 * @return
	 */
	public  BinarySearchTree.Node maxNode() {
		return maxNodeInner(binarySearchTree.root);
	}
	
	public  BinarySearchTree.Node maxNodeInner(Node node) {
		if (node.right!=null) {
			return maxNodeInner(node.right);
		}
		return node;
	}
	
	/**Ç°Çý
	 * @param node
	 * @return
	 */
	public BinarySearchTree.Node predecessorNode(Node node) {
		if (node.left!=null) {
			return maxNodeInner(node.left);
		}
		Node parent=node.parent;
		while (parent!=null&&parent.left==node) {
			parent=parent.parent;
		}
		return parent;
	}
	
}
