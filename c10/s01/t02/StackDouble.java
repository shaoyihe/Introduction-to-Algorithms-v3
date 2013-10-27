package c10.s01.t02;

import java.util.Arrays;

/** p131
 * 10.1-2
 * @author he
 * @email wubuqilai@gmail.com
 */
public class StackDouble {
	private int[] elements;
	private int count;
	private int topA; //point to current element
	private int topB;
	
	public StackDouble(int count) {
		this.elements=new int[count];
		this.count=count;
		topA=-1;			// A stack from 0->n-1
		topB=count;			//B stack from n-1->0
	}
	
	public void pushA(int element) throws Exception {
		if (isOverFlow()) { //overflow
			throw new Exception("overflow");
		}
		elements[++topA]=element;
	}
	
	public void pushB(int element) throws Exception {
		if (isOverFlow()) { //overflow
			throw new Exception("overflow");
		}
		elements[--topB]=element;
	}

	private boolean isOverFlow() {
		return topA+1==topB;
	}
	
	
	public int popA() throws Exception {
		if (topA==-1) { //underflow
			throw new Exception("underflow");
		}
		return elements[topA--];
	}
	
	public int popB() throws Exception {
		if (topB==count) { //underflow
			throw new Exception("underflow");
		}
		return elements[topB++];
	}
	
	public boolean stackAEmpty() {
		return topA == -1;
	}
	
	public boolean stackBEmpty() {
		return topB == count;
	}
	
	public String toString() {
		return "stack a : "+Arrays.toString(Arrays.copyOfRange(elements, 0, topA+1))+"\n"+
			   "stack b : "+Arrays.toString(Arrays.copyOfRange(elements, topB, count))+"\n";
		
	}

}
