package DSA.LinkedList;

public class Rotate {
    public static void rotateRight(SinglyLinkedList list, int steps) {
        // Handle edge cases: empty list or single-node list
        if (list == null || list.getHead() == null || list.getHead().getNext() == null) {
            return;
        }

        int length = 0;
        SinglyLinkedList.Node tail = null;
        SinglyLinkedList.Node current = list.getHead();

        // Step 1: Find the length of the list and get the tail node
        while (current != null) {
            length++;
            tail = current;
            current = current.getNext();
        }

        // Step 2: Normalize the steps in case steps > length
        steps = steps % length;
        if (steps == 0) {
            return;
        }

        // Step 3: Make the list circular by connecting tail to head
        tail.setNext(list.getHead());

        // Step 4: Find the new tail node (length - steps - 1 moves from head)
        current = list.getHead();
        int moves = length - steps - 1; // Steps to reach new tail
        while (moves-- > 0) {
            current = current.getNext();
        }

        // Step 5: Set the new head and break the circle
        list.setHead(current.getNext());
        current.setNext(null);
    }

    public static void rotateLeft(SinglyLinkedList list, int steps) {
        if (list == null || list.getHead() == null || list.getHead().getNext() == null) {
            return;
        }

        int length = 0;
        SinglyLinkedList.Node current = list.getHead();
        SinglyLinkedList.Node tail = null;

        // Step 1: Calculate the length of the list and identify the tail node
        while (current != null) {
            length++;
            tail = current;
            current = current.getNext();
        }

        // Step 2: Normalize steps in case steps >= length
        steps = steps % length;
        if (steps == 0) {
            return;
        }

        // Step 3: Make the list circular by linking tail to head
        tail.setNext(list.getHead());

        // Step 4: Walk to the new tail (steps - 1 moves from head)
        current = list.getHead();
        int moves = steps - 1;
        while (moves-- > 0) {
            current = current.getNext();
        }

        // Step 5: Set the new head and break the circle
        list.setHead(current.getNext());
        current.setNext(null);
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        for (int i = 0; i < 10; i++) {
            list.insertLast(i);
        }

        System.out.println("Original List:");
        list.print();

        Rotate.rotateRight(list, 3);
        System.out.println("After rotating right by 3:");
        list.print();

        Rotate.rotateLeft(list, 3);
        System.out.println("After rotating left by 3:");
        list.print();
    }
}
