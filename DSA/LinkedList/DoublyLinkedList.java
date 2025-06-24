package DSA.LinkedList;

public class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public void insertLast(int data) {
        Node node = new Node(data);
        if(tail == null) {
            head = tail = node;
        }
        else {
            tail.setNext(node);
            node.setPrevious(tail);
            tail = node;
        }
    }

    public void insertFirst(int data) {
        Node node = new Node(data);
        if(head == null) {
            head = tail = node;
        }
        else {
            head.setPrevious(node);
            node.setNext(head);
            head = node;
        }
    }

    public void remove(int data) {
        if (head == null) return;

        Node current = head;
        // Search for the node to remove
        while(current != null && current.getData() != data) {
            current = current.getNext();
        }

        // If not found
        if(current == null) return;

        // If it's the head node
        if(current == head) {
            head = head.getNext();
            if(head != null) {
                head.setPrevious(null);
            }
            else {
                tail = null;
            }
        }
        // If it's the tail node
        else if(current == tail) {
            tail = tail.getPrevious();
            if(tail != null) {
                tail.setNext(null);
            }
            else {
                head = null;
            }
        }
        // If it's a middle node
        else {
            current.getPrevious().setNext(current.getNext());
            current.getNext().setPrevious(current.getPrevious());
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
        Node current = head;
        Node previous = null;
        
        while(current != null) {
            // STEP-1: Swap previous and next pointers
            Node next = current.getNext();
            current.setNext(current.getPrevious());
            current.setPrevious(next);

            // STEP-2: Keep current as previous
            previous = current;
            // STEP-3: Keep next element as current and continue
            current = next;
        }

        // STEP-4: If the list is not empty perform head and tail swap
        if(previous != null) {
            tail = head;
            head = previous;
        }
    }

    public void printBackward() {
        Node current = tail;
        while(current != null) {
            System.out.print(current.getData() + " -> ");
            current = current.getPrevious();
        }
        System.out.println("null");
    }

    public void printForward() {
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

    public Node getTail() {
        return tail;
    }

    public static class Node {
        private final int data;
        private Node previous;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}