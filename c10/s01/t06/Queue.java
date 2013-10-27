package c10.s01.t06;

import java.util.Stack;

/** two stack build queue
 * strategy :
 * 		when enqueue element,all always push in stack 
 * 		when dequeue element,pop out stack,if null, pop all in to out
 * 
 * @author he
 */
public class Queue<T> {
	private  Stack<T> in=new Stack<T>();
	private  Stack<T> out=new Stack<T>();

	/** O(1)
	 * @param element
	 */
	public void enQueue(T element) {
		in.push(element);
	}
	
	/** worst: O(n)
	/** avg: O(1)
	 * @param element
	 * @return
	 */
	public T deQueue() {
		if (out.isEmpty()) {
			while (!in.isEmpty()) {
				out.push(in.pop());
			}
		}
		return out.pop();
	}
	
	public boolean isEmpty() {
		return out.isEmpty()&&in.isEmpty();
	}
}
