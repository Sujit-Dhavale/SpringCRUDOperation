package com.humanCloud.SpringBootProjectHumanCloud.HumanCloud;

import java.util.Deque;

import org.springframework.stereotype.Service;

@Service
public class Queue {
	public Queue() {
	this(5);
		// TODO Auto-generated constructor stub
	}

	private int size;
	private int front;
	private int rear;
	private int[] queueArray;

	public Queue(int inialsize) {
		this.size = inialsize;
		this.front = -1;
		this.rear = -1;
		this.queueArray = new int[inialsize];
	}

	public void enqueue(int val) {
		if (isFull()) {
			System.out.println("Queue is Full");
		} else {
			if (front == -1) {
				front = 0;
			}
			queueArray[++rear] = val;
		}
	}

	public int dequeue() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException("Queue is Empty ");
//			System.out.println("Queue is Empty");
//			return -1;
		} else {
			if (front == size) {
				front = -1;
				rear = -1;
				System.out.println("queue empty is not delete because empty");
				return -1;
			}
			return queueArray[front++];
		}
	}

	public int[] display() throws EmptyQueueException {
		if (!isEmpty()) {
			for (int i = front; i <= rear; i++) {
				System.out.print(queueArray[i] + " ");
				System.out.println();
			}
		} else
			throw new EmptyQueueException("Queue is Empty");
		// System.out.println("Queue is Empty");
		return queueArray;
	}

	public boolean isEmpty() {
		return front == -1;
	}

	public boolean isFull() {
		return rear == size - 1;
	}

	public static void main(String[] args) throws EmptyQueueException {

		Queue queueimp = new Queue(3);

		queueimp.enqueue(1);
		queueimp.enqueue(2);
		queueimp.enqueue(6);
		System.out.println(queueimp.isEmpty());
		System.out.println(queueimp.isFull());
		queueimp.dequeue();
		System.out.println("------------------");
		queueimp.display();
		queueimp.dequeue();
		System.out.println();
		queueimp.display();
		queueimp.dequeue();
		System.out.println("-----------------");
		queueimp.display();
	}
}
