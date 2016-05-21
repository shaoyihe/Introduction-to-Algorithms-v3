package c10.s02.others.links_with_sentinel;


/**singly linked circular list with sentinel 
 * @author he
 *
 */
public class LinkedList<T> {
	private Node<T> head; 
	private Node<T> tail; 
	private int size=0;
	
	public LinkedList() {
		// create sentinel
		tail=head=new Node<T>(null); 
		head.next=head;
	}
	
	/**	O(1)
	 * @param element
	 */
	public void insert(T element) {
		assertNotNull(element);
		++size;
		Node<T> newHead=new Node<T>(element);
		newHead.next=head;
		head=tail.next=newHead;
	}

	/**worst O(n)
	 * @param element is delete success
	 * @return
	 */
	public boolean delete(T element) {
		assertNotNull(element);
		for(Node<T> node=tail;!node.next.isSentinel();node=node.next){
			if (node.next.element.equals(element)) {
				if (node.next==head) { //reset head
					head=node.next.next;
				}
				node.next=node.next.next;
				--size;
				return true;
			}
		}
		return false;
	}
	
	/** worst O(n)
	 * @param element
	 * @return
	 */
	public int search(T element) {
		assertNotNull(element);
		int poistion=0;
		for(Node<T> node=head;!node.isSentinel();node=node.next,++poistion){
			if (node.element.equals(element)) {
				return poistion;
			}
		}
		return -1;
	}

	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	@Override
	public String toString() {
		StringBuilder resultBuilder=new StringBuilder();
		for(Node<T> node=head;!node.isSentinel();node=node.next){
			resultBuilder.append(node.element.toString()+",");
		}
		String result=resultBuilder.toString();
		
		return "["+ (result.length()>0 ? result.substring(0,result.length()-1) : "")+"]";
	}

	
	private void assertNotNull(T element) {
		if (element==null) {
			throw new NullPointerException();
		}
	}

	private class Node<T>{
		public Node<T> next=null;
		public T element;
		public Node(T element) {
			this.element = element;
		}
		public boolean isSentinel() {
			return element==null;
		}
	}
}
