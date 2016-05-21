package c12.s01.other;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;


/** util build BinarySearchTree
 * @author he
 *
 */
public class BinarySearchTree { 
	private Random random=new Random();
	public Node root;
	
	
	
	public BinarySearchTree(int nodeCount) {
		for (int i = 0; i < nodeCount; i++) {
			insert(random.nextInt(nodeCount*5));
		}
	}

	public void insert(int element) {
		Node newNode=new Node(element);
		if (root==null) {
			root=newNode;
		}else{
			Node node=root;
			for (;;) {
				if (element<node.element) {
					if (node.left==null) {
						node.left=newNode;
						break;
					}
					node=node.left;
				}else{
					if(node.right==null){
						node.right=newNode;
						break;
					}
					node=node.right;
				}
			}
			newNode.parent=node;
		}
	}
	
	public String breadthFirst() {
		if (root!=null) {
			Deque<Node> in=new ArrayDeque<Node>(); 
			in.addLast(root);
			Deque<Node> temp=new ArrayDeque<Node>(); 
			
			StringBuilder result=new StringBuilder(); 
			while(in.size()>0){
				while(in.size()>0){
					Node node=in.removeFirst();
					result.append(node.element+" ");
					if (node.left!=null) {
						temp.addLast(node.left);
					}
					if (node.right!=null) {
						temp.addLast(node.right);
					}
				}
				while(temp.size()>0) {
					in.addLast(temp.removeFirst());
				}
				result.append("\n");
			}
			return result.toString();
		}else {
			return "";
		}
	}
	
	public class Node{
		public int element;
		public Node parent;
		public Node left;
		public Node right;
		
		public Node(int element) {
			this.element=element;
		}
		
	}
	
}
