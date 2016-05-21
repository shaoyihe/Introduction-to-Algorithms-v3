package c12.s01.t03;

import java.util.Stack;

import c12.s01.other.BinarySearchTree;
import c12.s01.other.BinarySearchTree.Node;

/**12.1-3
 * @author he
 *
 */
public class Tree {
	public BinarySearchTree binarySearchTree=new BinarySearchTree(200);
	private StringBuilder result=new StringBuilder();
	
	/**
	 *  inorderTreeWalkRecursion
	 */
	public String inorderTreeWalkRecursion() {
		inorderTreeWalkRecursionInner(binarySearchTree.root);
		return resetResult();
	}

	public void inorderTreeWalkRecursionInner(BinarySearchTree.Node node) {
		if (node!=null) {
			inorderTreeWalkRecursionInner(node.left);
			processNode(node);
			inorderTreeWalkRecursionInner(node.right);
		}
	}

	/** inorderTreeWalk not Recursion
	 * @return 
	 */
	public String inorderTreeWalkLoop() {
		Stack<Node> stack=new Stack<Node>();
		Node node=binarySearchTree.root;
		stack.push(node);
		while(!stack.isEmpty()){
			//push cur node all left node
			for (Node left=node.left;left!=null;left=left.left) {
				stack.push(left);
			}
			
			// pop until  has right node
			while(!stack.isEmpty()){
				Node pop=stack.pop();
				processNode(pop);
				if (pop.right!=null) {
					node=pop.right;
					stack.push(node);
					break;
				}
			}
			
		}
		return resetResult();
	}
	
	
	/** inorderTreeWalk not Recursion not use 
	 * stack
	 * @return 
	 */
	public String inorderTreeWalkLoopNotStack() {
		Node node=binarySearchTree.root;
		while (node!=null) {
			Node mostLeft=node;
			while (mostLeft.left!=null) {
				mostLeft=mostLeft.left;
			}
			processNode(mostLeft);
			
			if (mostLeft==binarySearchTree.root) {
				node=node.right;
				continue;
			}
			
			if (mostLeft.right!=null) {
				node=mostLeft.right;
				continue;
			}
			
			while(mostLeft.parent!=null){
				if (mostLeft==mostLeft.parent.left) {
					processNode(mostLeft.parent);
					if (mostLeft.parent.right!=null) {
						node=mostLeft.parent.right;
						break;
					}
				}else if (mostLeft==mostLeft.parent.right) {
					if (mostLeft.parent==binarySearchTree.root) {
						node=null;
						break;
					}
				}
				mostLeft=mostLeft.parent;
			}
			
		}
		
		return resetResult();
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
