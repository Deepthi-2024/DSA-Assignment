// Question 6: Remove Duplicates from Linked-List

// Skill Mapping: Intermediate

// Description: Consider a Linked-List with N number of repeated integers in Data-Node.

// Task - WAP in Java to remove the repeated integer numbers from Linked-List.

// Sample input: Linked-List:- 2->5->12->2->3->5->1->2->5->5

// Output:- 2->5->12->3->1

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class removeDuplicatesLinkedlist {
    public static Node removeDuplicates(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node current = head;
        Node previous = null;
        HashSet<Integer> set = new HashSet<>();

        while (current != null) {
            if (set.contains(current.data)) {
                previous.next = current.next;
            } else {
                set.add(current.data);
                previous = current;
            }
            current = current.next;
        }

        return head;
    }

    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node head = null;
        Node tail = null;

        System.out.println("Enter the linked list values(Enter null to stop)");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("null")) {
                break;
            }

            int value = Integer.parseInt(input);
            Node newNode = new Node(value);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
        }

        System.out.println("\nOriginal Linked-List:");
        printLinkedList(head);

        head = removeDuplicates(head);

        System.out.println("\nLinked-List after removing duplicates:");
        printLinkedList(head);

        scanner.close();
    }
}


