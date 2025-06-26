package DSA.LinkedList;

import DSA.LinkedList.SinglyLinkedList.Node;

public class FindLastNthNode {
    public static Node execute(SinglyLinkedList list, int position) {
        if(list == null || list.getHead() == null) {
            return null;
        }

        Node slow = list.getHead();
        Node fast = list.getHead();

        // Move fast pointer n steps ahead
        while(position-- > 0) {
            if(fast == null) return null;
            fast = fast.getNext();
        }

        // Move both pointers until fast pointer reaches the end
        while(fast != null) {
            slow = slow.getNext();
            fast = fast.getNext();
        }

        // Return slow pointer which will be the last nth node
        return slow;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        for(int i = 0; i < 10; i++) {
            list.insertLast(i);
        }

        list.print();
        Node node = execute(list, 20);
        System.out.println("Last 20th Node: " + (node == null ? "null" : node.getData()));
        node = execute(list, 8);
        System.out.println("Last 8th Node: " + (node == null ? "null" : node.getData()));
        node = execute(list, 3);
        System.out.println("Last 3rd Node: " + (node == null ? "null" : node.getData()));
    }
}
