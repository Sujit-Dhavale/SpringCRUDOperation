package com.humanCloud.SpringBootProjectHumanCloud.HumanCloud;

public class dynamicqueue {
	private int dynamicsize;
	private int rear;
	private int front;
	private int[] queuearray;

	public dynamicqueue(int inialsize) {
		this.dynamicsize = inialsize;
		this.queuearray = new int[inialsize];
		this.rear = -1;
		this.front = -1;
	}

	public void enqueue(int val) {
		if (isFull()) {
			resize(dynamicsize * 2);
			enqueue(val);
		} else {
			if (front == -1) {
				front = 0;
			}
			queuearray[++rear] = val;
		}
	}

	public int deQueue() {
		if (isEmpty()) {
			System.out.println("Queue is Empty");
			return -1;
		} else {
			if (front == dynamicsize || front == rear + 1) {
				System.out.println("Queue is empty");
				front = -1;
				rear = -1;
				return -1;
			}
			return queuearray[front++];
		}
	}

	public void diplay() {
		if (!isEmpty()) {
			for (int i = front; i <= rear; i++) {
				System.out.println(queuearray[i] + " ");
			}
		} else {
			System.out.println("queue is empty");
		}
		System.out.println();
	}

	private boolean isEmpty() {
		return front == -1;
	}

	private boolean isFull() {
		return rear == dynamicsize - 1;
	}

	private void resize(int newdynamicSize) {
		int[] newQueueArray = new int[newdynamicSize];
		for (int i = 0; i < queuearray.length; i++) {
			newQueueArray[i] = queuearray[i];
		}
		queuearray = newQueueArray;
		dynamicsize = newdynamicSize;
	}

	public static void main(String[] args) {
		dynamicqueue queue = new dynamicqueue(2);
		queue.enqueue(10);
		queue.diplay();
		queue.deQueue();
	}
}
