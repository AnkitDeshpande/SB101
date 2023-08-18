package Assignment_no_1;

import java.util.ArrayList;

public class Stack<T> {
	private ArrayList<T> stack;

	public Stack() {
		super();
		// TODO Auto-generated constructor stub
		stack = new ArrayList<>();
	}

	public void push(T element) {
		// TODO Auto-generated method stub
		stack.add(element);

	}

	public T pop() throws Exception {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new Exception("Stack is Empty.");
		}
		return stack.remove(stack.size() - 1);
	}

	public T peek() throws Exception {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new Exception("Stack is Empty.");
		}
		return stack.get(stack.size() - 1);
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub

		return stack.isEmpty();
	}

	public void show() throws Exception {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new Exception("Stack is Empty.");
		}
		for (T st : stack) {
			System.out.println(st + " ");
		}
	}

}
