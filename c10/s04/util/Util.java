package c10.s04.util;

public class Util {
	public static class BinaryTree{
		public Node root;
		
		public static BinaryTree build(int height) {
			BinaryTree binaryTree=new BinaryTree();
			binaryTree.root=new Node(1);
			int[] arr=new int[]{1};
			buildInner(1,arr,height,binaryTree.root);
			return binaryTree;
		}
		
		private static void buildInner(int height,int[] arr,int maxHeight,Node node) {
			if (height>maxHeight) {
				return;
			}
			Node left= new Node(++arr[0]);
			node.left=left;
			Node right=new Node(++arr[0]);
			node.right=right;
			buildInner(height+1, arr, maxHeight, left);
			buildInner(height+1,arr, maxHeight, right);
		}
		
		public static class Node{
			public int element;
			public Node left; 
			public Node right;
			public Node(int element) {
				this.element = element;
			}
			
		}
	}
	
	public static void main(String[] args) {
		BinaryTree binaryTree=BinaryTree.build(3);
		System.err.println();
	}
	
}
