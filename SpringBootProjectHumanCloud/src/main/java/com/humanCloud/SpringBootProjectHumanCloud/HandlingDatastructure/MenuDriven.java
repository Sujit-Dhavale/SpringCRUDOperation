package com.humanCloud.SpringBootProjectHumanCloud.HandlingDatastructure;

import java.util.ArrayList;

public class MenuDriven {
	public static void main(String[] args) {
		manageMenu();
	}

	public static void manageMenu() {
		Menu stackMenu = new Menu(1, "stack");
		Menu queueMenu = new Menu(2, "Queue");
		Menu linkedlistMenu = new Menu(3, "LinkedList");
		Menu doublelinkedList = new Menu(4, "DoubleLinkedList");

		stackMenu.addMenuName(new MenuItem(1, "push"));
		stackMenu.addMenuName(new MenuItem(2, "pop"));
		stackMenu.addMenuName(new MenuItem(3, "peek"));
		stackMenu.addMenuName(new MenuItem(4, "exist"));

		queueMenu.addMenuName(new MenuItem(1, "enqueue"));
		queueMenu.addMenuName(new MenuItem(2, "dequeue"));
		queueMenu.addMenuName(new MenuItem(3, "display"));
		queueMenu.addMenuName(new MenuItem(4, "exist"));

		linkedlistMenu.addMenuName(new MenuItem(1, "insert"));
		linkedlistMenu.addMenuName(new MenuItem(2, "display"));
		linkedlistMenu.addMenuName(new MenuItem(3, "delete"));
		linkedlistMenu.addMenuName(new MenuItem(4, "exist"));

		doublelinkedList.addMenuName(new MenuItem(1, "addtoend"));
		doublelinkedList.addMenuName(new MenuItem(2, "addtobegin"));
		doublelinkedList.addMenuName(new MenuItem(3, "disaplayforward"));
		doublelinkedList.addMenuName(new MenuItem(4, "displayBackward"));
		doublelinkedList.addMenuName(new MenuItem(5, "deleteForward"));
		doublelinkedList.addMenuName(new MenuItem(6, "exist"));

		Menu menu = new Menu();
		menu.addMenuName(stackMenu);
		menu.addMenuName(queueMenu);
		menu.addMenuName(linkedlistMenu);
		menu.addMenuName(doublelinkedList);
		menu.displayMenu();
	}
}
