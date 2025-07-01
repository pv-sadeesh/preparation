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
            System.out.print(current.getData() + " -> ");
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

    public boolean isEmpty() {
        return head == null;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
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

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        for(int i = 0; i < 10; i++) {
            list.insertLast(i);
        }

        System.out.print("Before Reversal: ");
        list.print();

        System.out.println("Length Before Removal: " + list.length());
        list.remove(9);
        System.out.println("Length After Removal: " + list.length());

        list.reverse();
        
        System.out.print("After Reversal: ");
        list.print();
    }
}