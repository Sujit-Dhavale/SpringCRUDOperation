package com.humanCloud.SpringBootProjectHumanCloud.HandlingDatastructure;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.DoubleLinkedList;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.DoubleLinkedListException;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.EmptyLinkedListException;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.EmptyQueueException;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.EmptyStackException;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.LinkedList;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.Queue;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.Stack;

public class Menu extends MenuItem {

	HashMap<Integer, MenuItem> listmap = new HashMap<>();

	static Stack stk = new Stack(5);
	static Queue que = new Queue(5);
	static LinkedList ll = new LinkedList();
	static DoubleLinkedList dl = new DoubleLinkedList();
	static Scanner sc = new Scanner(System.in);

	public Menu() {
	}

	public Menu(int menuId, String menuName) {
		super(menuId, menuName);
	}

	public void addMenuName(MenuItem menuItem) {
		int menuId = menuItem.getId();
		listmap.put(menuId, menuItem);
	}

	public void displayMenu() {
		System.out.println("DataStructure");
		listmap.forEach((k, v) -> {
			System.out.println(+k + ":" + v.getItemName());
		});
		System.out.println("enter a choice:");
		int menuId = sc.nextInt();
		displaymenuItem(menuId);
	}

	public void displaymenuItem(int menuId) {

		Menu menu = (Menu) listmap.get(menuId);

		System.out.println(menu.getItemName());
		menu.listmap.forEach((k, v) -> {
			System.out.println(k + ":" + v.getItemName());
		});
		System.out.println("Enter choice number:  ");

		int choice = sc.nextInt();
		MenuItem menuItem = menu.listmap.get(choice);
		Back(menuItem);
		switch (menu.getItemName()) {
		case "stack": {
			StackOperation(choice);
			break;
		}
		case "Queue": {
			QueueOperation(choice);
			break;
		}
		case "LinkedList": {
			LinkedListOpertion(choice);
			break;
		}
		case "DoubleLinkedList": {
			DoubleLinkedListOperation(choice);
			break;
		}
		case "default": {
			System.err.println("Invalid choice");
			break;
		}
		}
		displaymenuItem(menuId);
	}

	public void StackOperation(int choice) {
		switch (choice) {
		case 1: {
			System.out.println("Put the Value: ");
			int val = sc.nextInt();
			stk.push(val);
			System.out.println("Value is add successfully");
			break;
		}
		case 2: {
			try {
				stk.pop();
				System.out.println("value is delete successfully");
			} catch (EmptyStackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case 3: {
			int val;
			try {
				val = stk.peek();
				System.out.println("value is top" + val);

			} catch (EmptyStackException e) {
				e.printStackTrace();
			}
			break;
		}
		case 4: {
			displayMenu();
		}
			break;
		}
	}

	public void QueueOperation(int choice) {
		switch (choice) {
		case 1: {
			System.out.println("Put the Value: ");
			int val = sc.nextInt();
			que.enqueue(val);
			System.out.println("Value is add successfully");
			break;
		}
		case 2:
			try {
				que.dequeue();
				System.out.println("value is delete successfully");
			} catch (EmptyQueueException e) {
				e.printStackTrace();
				break;
			}
		case 3: {
			try {
				que.display();
				System.out.println("value is Display");

			} catch (EmptyQueueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case 4: {
			displayMenu();
			break;
		}
		}
	}

	public void LinkedListOpertion(int choice) {
		switch (choice) {
		case 1: {
			System.out.println("Put the Value: ");
			int val = sc.nextInt();
			ll.insert(val);
			System.out.println("Value is add successfully");
			break;
		}
		case 2: {
			try {
				ll.display();
				System.out.println("value is display successfully");

			} catch (EmptyLinkedListException e) {
				e.printStackTrace();
			}
			break;
		}
		case 3: {
			int val = sc.nextInt();
			try {
				ll.delete(val);
				System.out.println("value is delete successfully");
			} catch (EmptyLinkedListException e) {
				e.printStackTrace();
			}
			break;
		}
		}

	}

	public void DoubleLinkedListOperation(int choice) {
		switch (choice) {
		case 1: {
			System.out.println("Put the Value: ");
			int val = sc.nextInt();
			dl.addtoend(val);
			System.out.println("Value is add successfully");
		}
		case 2: {
			int val = sc.nextInt();
			dl.addtobegin(val);
			System.out.println("value is add successfully");

		}
		case 3: {
			try {
				dl.displayForward();
				System.out.println("value is display successfully");
			} catch (DoubleLinkedListException e) {
				e.printStackTrace();
			}
		}
		case 4: {
			int val = sc.nextInt();
			dl.displayBackward();
			System.out.println(" value is display successfully ");
		}
		case 5: {
			int val = sc.nextInt();
			try {
				dl.deleteForward(val);
				System.out.println("value is deleteForward");
			} catch (DoubleLinkedListException e) {
				e.printStackTrace();
			}
		}
		}
	}

	public void Back(MenuItem menuItem) {
		if (menuItem.getItemName().equals("exist")) {
			displayMenu();
		}
	}
}
