// Question 5: Merge and Sort the elements in two Linked-List

// Skill Mapping: Intermediate

// Description: Consider two Linked-List with N number of integers in Data-Node respectively.

// Task 1- WAP in Java to merge both Linked-Lists.

// Task 2 - Sort the output Linked-List basis of its Data-Node in ascending order.

// Sample input: Linked-List-1:- 25->35->12->4->36->48

// Linked-List-2:- 8->32->22->45->63->49

// Output:- 4->8->12->22->25->32->35->36->45->48->49->63

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MergeAndSortLinkedLists {

    public static Node merge(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        Node mergedHead;
        if (head1.data <= head2.data) {
            mergedHead = head1;
            head1 = head1.next;
        } else {
            mergedHead = head2;
            head2 = head2.next;
        }

        Node current = mergedHead;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }
        if (head1 != null) {
            current.next = head1;
        } else {
            current.next = head2;
        }

        return mergedHead;
    }

    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node middle = findMiddle(head);
        Node secondHalf = middle.next;
        middle.next = null;

        Node sortedFirstHalf = mergeSort(head);
        Node sortedSecondHalf = mergeSort(secondHalf);

        return merge(sortedFirstHalf, sortedSecondHalf);
    }

    public static Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.print("null");
    }
     public static Node createLinkedListFromInput() {
        Scanner scanner = new Scanner(System.in);
        Node head = null;
        Node current = null;

        System.out.println("Enter 'null' to stop input: ");

        while (true) {
            String input = scanner.next();

            if (input.equals("null")) {
                break;
            }

            int data = Integer.parseInt(input);
            Node newNode = new Node(data);

            if (head == null) {
                head = newNode;
                current = head;
            } else {
                current.next = newNode;
                current = current.next;
            }
        }

        return head;
    }
    

    public static void main(String[] args) {
        Node list1 =createLinkedListFromInput();
        Node list2 = createLinkedListFromInput();


        System.out.println("\nLinked-List-1:");
        printLinkedList(list1);
        System.out.println();

        System.out.println("\nLinked-List-2:");
        printLinkedList(list2);
        System.out.println();

        Node mergedList = merge(list1, list2);
        Node sortedList = mergeSort(mergedList);

        System.out.println("\nOutput:");
        printLinkedList(sortedList);
    }
}

