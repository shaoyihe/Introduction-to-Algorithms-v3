package c10.s01.t05;

import java.util.Arrays;

/** p131
 * 10.1-5
 * @author he
 * @email wubuqilai@gmail.com
 */
public class QueueTwoWay {
	private int[] elements;
	private int head=0;
	private int tail=0; 	//not include 
	private int maxCount;
	private int curElementCount=0;
	
	public  QueueTwoWay(int count) {
		elements=new int[count];
		this.maxCount=count;
	}
	
	/**enQueue to  tail
	 * @param element
	 * @throws Exception 
	 */
	public void enQueue(int element) throws Exception{
		if (maxCount==curElementCount) {
			throw new Exception("OverFlow");
		}
		elements[tail]=element;
		tail=(tail+1==maxCount ? 0 : tail+1);
		++curElementCount;
	}
	
	public void enQueueToHead(int element) throws Exception{
		if (maxCount==curElementCount) {
			throw new Exception("OverFlow");
		}
		head=(head-1==-1 ? maxCount-1 : head-1);
		elements[head]=element;
		++curElementCount;
	}
	
	/**deQueue from head
	 * @return
	 * @throws Exception
	 */
	public int deQueue() throws Exception{
		if (isEmpty()) {
			throw new Exception("UnderFlow");
		}
		int element=elements[head];
		head=(head+1==maxCount ? 0 :head+1);
		--curElementCount;
		return element;
	}
	
	public int deQueueFromTail() throws Exception{
		if (isEmpty()) {
			throw new Exception("UnderFlow");
		}
		tail=(tail-1==-1 ? maxCount-1 :tail-1);
		int element=elements[tail];
		--curElementCount;
		return element;
	}

	public boolean isEmpty() {
		return curElementCount==0;
	}
	
	public int size() {
		return curElementCount;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(elements)+"\n head :"+head+"\n tail :"+tail;
	}
	
}
