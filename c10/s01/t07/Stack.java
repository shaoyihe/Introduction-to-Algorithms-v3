package c10.s01.t07;


import c10.s01.t05.QueueTwoWay;

/** 10.1-7
 * two queue build stack
 * @author he
 * @email wubuqilai@gmail.com
 */
public class Stack {
	
	private QueueTwoWay frist; 
	private QueueTwoWay second;
	
	public Stack(int count){
		frist=new QueueTwoWay(count);
		second=new QueueTwoWay(count);
	}
	
	/** O(1)
	 * @param element
	 * @throws Exception
	 */
	public void push(int element) throws Exception {
		QueueTwoWay notEmptyQueue=second.isEmpty()?frist:second;
		notEmptyQueue.enQueue(element);
	}
	
	/**  O(n)
	 * @return
	 * @throws Exception
	 */
	public int pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("underflow");
		}
		QueueTwoWay emptyQueue=frist.isEmpty()? frist :second;
		QueueTwoWay notEmptyQueue=frist==emptyQueue ?second :frist;
		while (notEmptyQueue.size()>1) {
			emptyQueue.enQueue(notEmptyQueue.deQueue());
		}
		return notEmptyQueue.deQueue();
	}
	
	public boolean isEmpty() {
		return frist.isEmpty()&&second.isEmpty();
	}
	
	public int size() {
		return frist.size()+second.size();
	}
	
}
