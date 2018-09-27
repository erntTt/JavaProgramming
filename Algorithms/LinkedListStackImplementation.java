import java.util.NoSuchElementException;

public class DynamicStack {
	private class Node {
		private Object item;
		private Node next;
		
		Node(Object item){
			this.item = item;
			this.next = null;
		}
		
		Node(Object item, Node nextNode){
			this.item = item;
			this.next  = nextNode;
		}
	}
	
	private int count;
	private Node top;
	
	public DynamicStack() {
		this.top = null;
		this.count = 0;
	}
	
	public int size() {
		return count;
	}
	
	public void clear() {
		top = null;
	}
	
	public void push(Object item) {
		if(top == null) {
			top = new Node(item);
		}else {
			Node newNode = new Node(item,top);
			top = newNode;
		}
		count++;
	}
	
	public Object peek() {
		if(top == null) {
			throw new NoSuchElementException("Underflow Exception");
		}else {
			return top.item;
		}
	}
	
	public Object pop() {
		Node currentNode = top;
		if(top == null) {
			throw new NoSuchElementException("Underflow Exception");
		}else {
			Node nextNode = top.next;
			top = null;
			top = nextNode;
		}
		count--;
		return currentNode.item;
		
	}
	
	public void iterate() {
		Node currentNode = top;
		while(currentNode != null) {
			System.out.print(currentNode.item + " ");
			currentNode = currentNode.next;
		}
	}
	
	
	public static void main(String[] args) {
		DynamicStack dynamic = new DynamicStack();
		dynamic.push("Milk1");
		dynamic.push("Milk2");
		dynamic.push("Milk3");
		dynamic.pop();
		
		
		dynamic.iterate();
		System.out.println(dynamic.size());
		
		
	}

}
