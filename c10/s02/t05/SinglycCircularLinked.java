package c10.s02.t05;


/**SinglycCircularLinked 
 * 10.2-5
 * @author he
 *@email wubuqilai@gmail.com
 */
public class SinglycCircularLinked<T> {
	
	private Node<T> head=null;
	private Node<T> tail=null;
	int count=0;
	
	/** O(1)
	 * insert to head
	 * @param element 
	 */
	public void insert(T element) {
		if (head==null) {
			head=new Node<T>(element);
			head.next=head;
			tail=head;
		}else {
			Node<T> newHead=new Node<T>(element);
			newHead.next=head;
			tail.next=head=newHead;
		}
		++count;
	}
	
	/** worst O(n)
	 * @param element
	 * @return
	 */
	public int search(T element) {
		if (head==null) {
			return -1;
		}
		if (head.element.equals(element)) {
			return 0;
		}
		
		int poistion=1;
		for (Node<T> node=head.next;node!=head;node=node.next,++poistion) {
			if (node.element.equals(element)) {
				return poistion;
			}
		}
		return -1;
	}
	
	/** worst O(n)
	 * @param element
	 * @return
	 */
	public boolean delete(T element) {
		if (head==null) {
			return false;
		}
		
		if (head.element.equals(element)) {
			if (head.next==head) {
				head=tail=null;
			}else {
				tail.next=head=head.next;
			}
			--count;
			return true;
		}
		
		for (Node<T> node=head;node.next!=head;node=node.next) {
			if (node.next.element.equals(element)) {
				node.next=node.next.next;
				--count;
				return true;
			}
		}
		return false;
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
