package com.humanCloud.SpringBootProjectHumanCloud.HandlingDatastructure;

import java.util.Scanner;

import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.DoubleLinkedListException;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.EmptyLinkedListException;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.EmptyQueueException;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.EmptyStackException;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.Stack;

public class StackMethods {
	static Stack st = new Stack(5);

	public static void DisplaystackOpertions() throws EmptyStackException, EmptyQueueException, EmptyLinkedListException, DoubleLinkedListException {
		System.out.println("----------Display Stack Operation----------");
		System.out.println("1.Push");
		System.out.println("2.pop");
		System.out.println("3.Peek");
		System.out.println("4.Back");
		System.out.println("Enter a Choice Number: ");
		Scanner sc = new Scanner(System.in);
		int choiceNo = sc.nextInt();
		do {
			if (choiceNo == 1) {
				System.out.println("Put the value:");
				Scanner scanner = new Scanner(System.in);
				int val = scanner.nextInt();
				st.push(val);
				System.out.println("Push value inerted");
				StackMethods.DisplaystackOpertions();
			} else if (choiceNo == 2) {
				st.pop();
				System.out.println("pop value is deleted ");
				StackMethods.DisplaystackOpertions();

			} else if (choiceNo == 3) {
				st.peek();
				System.out.println("Peek value is :" + st.peek());
				StackMethods.DisplaystackOpertions();
			} else if (choiceNo == 4) {
				Datastructure.displayAllDataStructure();
			}
		} while (choiceNo != 4);
	}
}
