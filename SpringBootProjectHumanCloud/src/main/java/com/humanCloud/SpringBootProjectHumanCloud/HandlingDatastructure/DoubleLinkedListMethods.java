package com.humanCloud.SpringBootProjectHumanCloud.HandlingDatastructure;

import java.util.Scanner;

import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.DoubleLinkedList;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.DoubleLinkedListException;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.EmptyLinkedListException;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.EmptyQueueException;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.EmptyStackException;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.LinkedList;

public class DoubleLinkedListMethods {

	static DoubleLinkedList D = new DoubleLinkedList();

	public static void DisplayDoubleLinkedListOpertions()
			throws DoubleLinkedListException, EmptyStackException, EmptyQueueException, EmptyLinkedListException {
		System.out.println("----------Display DoubleLinkedList Operation----------");
		System.out.println("1.addtoend");
		System.out.println("2.addtobegin");
		System.out.println("3.displayForward");
		System.out.println("4.displayBackward");
		System.out.println("5.delete");
		System.out.println("6.deleteForward");
		System.out.println("7.Back");
		System.out.println("Enter a Choice Number: ");
		Scanner sc = new Scanner(System.in);
		int choiceNo = sc.nextInt();
		do {
			if (choiceNo == 1) {
				System.out.println("put the value:");
				Scanner scnr = new Scanner(System.in);
				int val = scnr.nextInt();
				D.addtobegin(val);
				System.out.println(" value is inerted............");
				DoubleLinkedListMethods.DisplayDoubleLinkedListOpertions();
			} else if (choiceNo == 2) {
				Scanner scnr = new Scanner(System.in);
				int val = scnr.nextInt();
				D.addtoend(val);
				System.out.println("value is inserted.............");
				DoubleLinkedListMethods.DisplayDoubleLinkedListOpertions();
			} else if (choiceNo == 3) {
				D.displayForward();
				System.out.println("value is Display Forward..........");
				DoubleLinkedListMethods.DisplayDoubleLinkedListOpertions();
			} else if (choiceNo == 4) {
				D.displayBackward();
				System.out.println("value is Display Backward..........");
				DoubleLinkedListMethods.DisplayDoubleLinkedListOpertions();
			} else if (choiceNo == 5) {
				D.delete();
				System.out.println("value is deleted..........");
				DoubleLinkedListMethods.DisplayDoubleLinkedListOpertions();
			} else if (choiceNo == 6) {
				Scanner scnr = new Scanner(System.in);
				int val = scnr.nextInt();
				D.deleteForward(val);
				System.out.println("value is deleted Forward.........");
				DoubleLinkedListMethods.DisplayDoubleLinkedListOpertions();
			} else if (choiceNo == 7) {
				Datastructure.displayAllDataStructure();
			} else {
				System.out.println("Invalid choice no");
			}
		} while (choiceNo != 7);
		System.out.println("Sorry please select valid choiceNo");
	}
}
