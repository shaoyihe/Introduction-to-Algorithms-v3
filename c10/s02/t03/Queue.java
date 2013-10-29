package c10.s02.t03;


/**singly linked build Stack Queue
 * 10.2-3
 * @author he
 * @email wubuqilai@gmail.com
 */
public class Queue<T> {
	private Node<T> head=null; 
	private Node<T> tail=null; 
	int count=0;
	
	/** O(1)
	 * @param element
	 */
	public void enQueue(T element) {
		if (head==null) {
			head=tail=new Node<T>(element);
		}else {
			tail=tail.next=new Node<T>(element);
		}
		++count;
	}
	
	/** O(1)
	 * @return
	 */
	public T deQueue() {
		if (head==null) {
			return null;
		}else {
			--count;
			Node<T> deletedHead=head;
			head=head.next;
			if (head==null) {
				tail=null;
			}
			return deletedHead.element;
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
		public Node(T element) {
			this.element = element;
		}
	}
}
