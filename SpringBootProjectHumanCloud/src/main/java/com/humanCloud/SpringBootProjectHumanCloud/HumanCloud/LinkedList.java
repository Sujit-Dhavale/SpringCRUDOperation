
package com.humanCloud.SpringBootProjectHumanCloud.HumanCloud;

import org.springframework.stereotype.Service;

@Service
public class LinkedList {
	private Node head;
	private int size = 0;

	public LinkedList() {
		super();
	}

	class Node {
		private int val;
		private Node next;

		public Node(int val) {
			this.val = val;
		}
	}

	public Node insert(int val) {
		Node node = new Node(val);
		Node temp = head;
		if (head == null) {
			head = node;
		} else {
			for (int i = 0; i < size; i++) {
				temp = temp.next;
			}
			temp.next = node;
			size++;
		}
		return node;
	}

	public int[] display() throws EmptyLinkedListException {
		Node temp = head;
		int[] arr = new int[size + 1];
		if (temp != null) {
			int j = 0;
			while (temp != null) {
				System.out.print(temp.val + " ");
				arr[j++] = temp.val;
				temp = temp.next;
			}
			System.out.println();
		} else {
			throw new EmptyLinkedListException("linked list is empty");
			// System.out.println("linked list is empty");
		}
		return arr;
	}

	public void delete() {
		head = head.next;
		--size;
	}

	public void delete(int index) throws EmptyLinkedListException {
		Node temp = head;
		if (temp == null) {
			throw new EmptyLinkedListException("linked list is empty");
			// System.out.println("Linked list is Empty");
			// return;
		}
		if (index > size) {
			System.out.println("IndexOutBoundException");
			return;
		}
		if (1 == index) {
			delete();
		} else {
			// Previous node deleted by node
			for (int i = 2; i < index; i++) {
				temp = temp.next;
				System.out.print(temp + " " + i);
			}
			Node node = temp.next.next;
			temp.next = node;
			--size;
		}
		return;
	}

	public static void main(String[] args) throws EmptyLinkedListException {
		LinkedList l = new LinkedList();
		l.insert(9);
		l.insert(8);
		l.insert(7);
		l.insert(6);
		l.insert(6);
		l.display();
		l.delete(2);
		l.display();
		l.insert(6);
		l.insert(2);
		l.insert(2);
		l.display();

	}
}