package DSA.LinkedList;

import DSA.LinkedList.SinglyLinkedList.Node;

public class FindMiddle {
    public static Node execute(SinglyLinkedList list) {
        Node slow = list.getHead();
        Node fast = list.getHead();

        while(fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        // Odd number of nodes: returns the actual middle.
        // Even number of nodes: returns the second middle node.
        return slow;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        for(int i = 0; i < 10; i++) {
            list.insertLast(i);
        }

        System.out.print("Before Removal: ");
        list.print();
        Node middle = FindMiddle.execute(list);
        if(middle != null) {
            System.out.println("Middle: " + middle.getData());
        }

        list.remove(0);
        list.remove(1);
        list.remove(2);
        list.remove(3);

        System.out.print("After Removal: ");
        list.print();
        middle = FindMiddle.execute(list);
        if(middle != null) {
            System.out.println("Middle: " + middle.getData());
        }
    }
}
