package com.humanCloud.SpringBootProjectHumanCloud.HandlingDatastructure;

import java.util.Scanner;

import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.EmptyLinkedListException;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.EmptyQueueException;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.EmptyStackException;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.Queue;

public class QueueMethods {

	static Queue queue = new Queue(5);

	public static void DisplayQueueOpertions()
			throws EmptyQueueException, EmptyStackException, EmptyLinkedListException {
		System.out.println("----------Display Queue Operation----------");
		System.out.println("1.Enqueue");
		System.out.println("2.Dequeue");
		System.out.println("3.Display");
		System.out.println("4.Back");
		System.out.println("Enter a Choice Number: ");
		Scanner sc = new Scanner(System.in);
		int choiceNo = sc.nextInt();
		do {
			if (choiceNo == 1) {
				System.out.println(" Put the value ");
				Scanner scn = new Scanner(System.in);
				int val = scn.nextInt();
				queue.enqueue(val);
				System.out.println(" value inerted");
				QueueMethods.DisplayQueueOpertions();
			} else if (choiceNo == 2) {
				queue.dequeue();
				System.out.println("value is deleted ");
				QueueMethods.DisplayQueueOpertions();
			} else if (choiceNo == 3) {
				queue.display();
				QueueMethods.DisplayQueueOpertions();
			} else {
				System.out.println("invalid choice");
			}
		} while (choiceNo != 4);
	}
}
