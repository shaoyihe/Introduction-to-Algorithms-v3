package c12.s01.t04;

import java.util.Stack;

import c12.s01.other.BinarySearchTree;
import c12.s01.other.BinarySearchTree.Node;

public class Tree {
	public BinarySearchTree binarySearchTree=new BinarySearchTree(10);
	private StringBuilder result=new StringBuilder();
	
	/** pre order walk
	 * @return
	 */
	public String preOrderTreeWalk() {
		preOrderTreeWalkInner(binarySearchTree.root);
		return resetResult();
	}
	
	private void preOrderTreeWalkInner(BinarySearchTree.Node node) {
		if (node!=null) {
			processNode(node);
			preOrderTreeWalkInner(node.left);
			preOrderTreeWalkInner(node.right);
		}
	}
	
	
	/** inorderTreeWalk not Recursion
	 * @return 
	 */
	public String preorderTreeWalkLoop() {
		Stack<Node> stack=new Stack<Node>();
		Node node=binarySearchTree.root;
		processNode(node);
		stack.push(node);
		while(!stack.isEmpty()){
			//push cur node all left node
			for (Node left=node.left;left!=null;left=left.left) {
				processNode(left);
				stack.push(left);
			}
			
			// pop until  has right node
			while(!stack.isEmpty()){
				Node pop=stack.pop();
				if (pop.right!=null) {
					node=pop.right;
					processNode(node);
					stack.push(node);
					break;
				}
			}
			
		}
		return resetResult();
	}
	
	/** post order walk
	 * @return
	 */
	public String postOrderTreeWalk() {
		postOrderTreeWalkInner(binarySearchTree.root);
		return resetResult();
	}
	
	private void postOrderTreeWalkInner(BinarySearchTree.Node node) {
		if (node!=null) {
			postOrderTreeWalkInner(node.left);
			postOrderTreeWalkInner(node.right);
			processNode(node);
		}
	}
	
	private void processNode(BinarySearchTree.Node node) {
		result.append(node.element+",");
	}
	
	private String resetResult() {
		StringBuilder before=result;
		result=new StringBuilder();
		return before.toString();
	}
}
