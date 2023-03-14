package com.humanCloud.SpringBootProjectHumanCloud.HandlingDatastructure;

import java.util.Scanner;

import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.DoubleLinkedListException;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.EmptyLinkedListException;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.EmptyQueueException;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.EmptyStackException;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.Stack;

public class Datastructure {

	public static void main(String[] args)
			throws EmptyStackException, EmptyQueueException, EmptyLinkedListException, DoubleLinkedListException {
		Datastructure.displayAllDataStructure();

	}

	public static void displayAllDataStructure()
			throws EmptyStackException, EmptyQueueException, EmptyLinkedListException, DoubleLinkedListException {
		System.out.println("----------Display All Datastructure-------");
		System.out.println("1.Stack");
		System.out.println("2.Queue");
		System.out.println("3.LinkedList");
		System.out.println("4.DoubleLinkedList");
		System.out.println("5.Exist");
		System.out.println("Enter choice no");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();

		do {
			if (choice == 1) {
				StackMethods.DisplaystackOpertions();
				displayAllDataStructure();
			} else if (choice == 2) {
				QueueMethods.DisplayQueueOpertions();
				displayAllDataStructure();
			} else if (choice == 3) {
				LinkedListMethods.DisplayLinkedListOpertions();
				displayAllDataStructure();
			} else if (choice == 4) {
				DoubleLinkedListMethods.DisplayDoubleLinkedListOpertions();
				displayAllDataStructure();

			} else {
				System.out.println("Choice no is invalid ,please vaild choice no ");
			}
		} while (choice != 5);

		System.out.println("End the Application......");
		System.exit(0);
	}
}
