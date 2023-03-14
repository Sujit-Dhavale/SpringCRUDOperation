package com.humanCloud.SpringBootProjectHumanCloud.HandlingDatastructure;

import java.util.Scanner;

import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.DoubleLinkedListException;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.EmptyLinkedListException;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.EmptyQueueException;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.EmptyStackException;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.LinkedList;

public class LinkedListMethods {

	static LinkedList l = new LinkedList();

	public static void DisplayLinkedListOpertions()
			throws EmptyStackException, EmptyQueueException, EmptyLinkedListException, DoubleLinkedListException {
		System.out.println("----------Display LinkedList Operation----------");
		System.out.println("1.insert");
		System.out.println("2.display");
		System.out.println("3.delete");
		System.out.println("4.Back");
		System.out.println("Enter a Choice Number: ");
		Scanner sc = new Scanner(System.in);
		int choiceNo = sc.nextInt();
		do {
			if (choiceNo == 1) {
				System.out.println("put the value:");
				Scanner scnr = new Scanner(System.in);
				int val = scnr.nextInt();
				l.insert(val);
				System.out.println(" value inerted............");
				LinkedListMethods.DisplayLinkedListOpertions();
			} else if (choiceNo == 2) {
				l.display();
				System.out.println("value is display.............");
				LinkedListMethods.DisplayLinkedListOpertions();
			} else if (choiceNo == 3) {
				System.out.println("put the index value: ");
				Scanner scr = new Scanner(System.in);
				int index = scr.nextInt();
				l.delete(index);
				System.out.println("value is deleted..........");
				LinkedListMethods.DisplayLinkedListOpertions();
			} else if (choiceNo == 4) {
				Datastructure.displayAllDataStructure();
			} else {
				System.out.println("Invalid choice no");
			}
		} while (choiceNo != 4);
		System.out.println("Sorry please select valid choiceNo");
	}
}
