package c10.s02.t02;

/**singly linked build Stack
 * 10.2-2
 * @author he
 * @email wubuqilai@gmail.com
 */
public class Stack<T> {
	private Node<T> head=null;
	private int count=0;
	
	/**0(1)
	 * @param element
	 */
	public void push(T element) {
		head=new Node<T>(element,head);
		++count;
	}
	
	/** O(1)
	 * @return
	 */
	public T pop() {
		if (head==null) {
			return null;
		}else {
			--count;
			Node<T> deletedHead=head;
			head=head.next;
			return  deletedHead.element;
		}
	}
	
	public boolean isEmpty() {
		return head==null;
	}
	
	public int size() {
		return count;
	}
	
	
	private class Node<T>{
		public Node<T> next=null;
		public T element;
		public Node(T element,Node<T> next) {
			this.element = element;
			this.next=next;
		}
	}
}
