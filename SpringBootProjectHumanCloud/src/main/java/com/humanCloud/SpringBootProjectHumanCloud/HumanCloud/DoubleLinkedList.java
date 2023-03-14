package com.humanCloud.SpringBootProjectHumanCloud.HumanCloud;

import org.springframework.stereotype.Service;

@Service
public class DoubleLinkedList {
	private Node head;
	private int size;

	class Node {
		private Node pre;
		private int data;
		private Node next;

		public Node(int data) {
			this.pre = null;
			this.data = data;
			this.next = null;
		}
	}

	public int addtoend(int val) {
		Node node = new Node(val);
		if (size == 0) {
			head = null;
		}
		Node temp = head;
		if (head == null) {
			head = node;
		} else {
			for (int i = 1; i < size; i++) {
				temp = temp.next;
			}
			temp.next = node;
			node.pre = temp;
		}
		return size++;
	}

	public int addtobegin(int val) {
		Node node = new Node(val);
		if (size == 0) {
			head = node;
		} else {
			Node temp = head;
			head = node;
			temp.pre = node;
			node.next = temp;
		}
		return size++;
	}

	public int[] displayForward() throws DoubleLinkedListException {

		int[] arr = new int[size];
		if (size == 0) {
			throw new DoubleLinkedListException("Empty List");
			// System.out.println("Empty list");
		}
		Node temp = head;
		int j = 0;
		while (temp != null) {

			System.out.print(temp.data + " ");
			arr[j++] = temp.data;
			temp = temp.next;

		}
		System.out.println();
		return arr;

	}

	public void displayBackward() {
		if (size == 0) {
			head = null;
		}
		Node temp = head;
		for (int i = 1; i < size; i++) {
			temp = temp.next;
		}
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.pre;
		}
		System.out.println();

	}

	public void delete() throws DoubleLinkedListException {
		if (size == 0) {
			throw new DoubleLinkedListException("Empty List");
			// System.out.println("Empty List");
		}
		head = head.next;
		head.pre = null;
		size--;
	}

	public void deleteForward(int index) throws DoubleLinkedListException {
		if (size == 0) {
			throw new DoubleLinkedListException("Empty List");
			// System.out.println("Empty List");
		}
		if (index > size) {
			System.out.println("IndexOutBoundException");
		}
		Node temp = head;
		if (index == 1) {
			delete();
		} else {
			for (int i = 2; i < index; i++) {
				temp = temp.next;
			}
			if (size == index) {
				temp.next = null;
			} else {
				Node node = temp.next.next;
				node.pre = temp;
				temp.next = node;
			}
			size--;
		}
	}

	public static void main(String[] args) throws DoubleLinkedListException {
		DoubleLinkedList ss = new DoubleLinkedList();
		ss.addtobegin(1);
		ss.addtoend(9);
		ss.addtoend(8);
		ss.addtobegin(2);
		ss.addtobegin(3);
		// ss.displayForward();
		// ss.displayBackward();
		// ss.deleteForward(3);
		// ss.deleteForward(2);
		ss.displayForward();
	}
}
