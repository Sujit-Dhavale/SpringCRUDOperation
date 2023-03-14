package com.humanCloud.SpringBootProjectHumanCloud.HumanCloud;

import org.springframework.stereotype.Service;

@Service
public class Stack {
	public Stack() {
		this(5);
		// TODO Auto-generated constructor stub
	}

	private int dynamicSize;
	private int[] stackArray;
	private int top;

	public Stack(int initalSize) {
		this.dynamicSize = initalSize;
		this.stackArray = new int[initalSize];
		this.top = -1; // 0
	}

	public void push(int val) {
		if (!isFull()) {
			stackArray[++top] = val;
		} else {
			reSize(dynamicSize * 2);
			push(val);
		}
	}

	public int pop() throws EmptyStackException {
		if (!isEmpty()) {
			return stackArray[top--];
		} else {
			throw new EmptyStackException("this stack is already empty");
			// -1
		}
	}

	public int peek() throws EmptyStackException {
		if (!isEmpty()) {
			return stackArray[top];
		} else {
			throw new EmptyStackException("the stack is empty ,can not be peek");
			// -1
		}
	}

	public void reSize(int newDynamicSize) {
		int newStackArray[] = new int[newDynamicSize];
		for (int i = 0; i < stackArray.length; i++) {
			newStackArray[i] = stackArray[i];
		}
		stackArray = newStackArray;
		dynamicSize = newDynamicSize;
	}

	public int[] display() {
		for (int i = 0; i < stackArray.length; i++) {
			System.out.print(stackArray[i] + " ");
		}
		return stackArray;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top + 1 == dynamicSize;
	}

	public static void main(String[] args) throws EmptyStackException {
		Stack stack = new Stack(2);
		stack.push(2);
		stack.push(3);
		stack.push(5);
		stack.push(9);
//		System.out.println(stack.isFull());
//		System.out.println(stack.isEmpty());
//		stack.push(7);
//		System.out.println("----------------------");
//		stack.peek();
//		System.out.println(stack.peek());
//		stack.pop();
//		System.out.println(stack.pop());
//		System.out.println(stack.peek());
//		stack.pop();
//		stack.pop();
//		System.out.println(stack.pop());
//		System.out.println("----------------------");
		stack.display();
	}
}
