package DSA.LinkedList;

public class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList() {
        head = null;
    }

    public void insertLast(int data) {
        Node node = new Node(data);
        if(head == null) {
            head = node;
            return;
        }

        Node current = head;
        while(current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(node);   
    }

    public void insertFirst(int data) {
        Node node = new Node(data);
        node.setNext(head);
        head = node;
    }

    public void remove(int data) {
        if(head == null) {
            return;
        }

        if(head.getData() == data) {
            head = head.getNext();
            return;
        }

        Node current = head;
        while(current.getNext() != null && current.getNext().getData() != data) {
            current = current.getNext();
        }

        if(current.getNext() != null) {
            current.setNext(current.getNext().getNext());
        }
    }

    public boolean contains(int data) {
        Node current = head;
        while(current != null) {
            if(current.getData() == data) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void reverse() {
        Node previous = null;
        Node current = head;
        Node next = null;

        while(current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }

        head = previous;
    }

    public void print() {
        Node current = head;
        while(current != null) {
            System.out.println(current.getData() + " -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public int length() {
        int count = 0;
        Node current = head;
        while(current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public Node getHead() {
        return head;
    }
    
    public static class Node {
        private final int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public int getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}