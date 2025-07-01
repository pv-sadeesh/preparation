package DSA.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static void removeDuplicatesFromSortedList(SinglyLinkedList list) {
        if (list == null || list.getHead() == null || list.getHead().getNext() == null) {
            return;
        }

        SinglyLinkedList.Node current = list.getHead();
        while (current != null && current.getNext() != null) {
            if (current.getData() == current.getNext().getData()) {
                current.setNext(current.getNext().getNext());
            }
            else {
                current = current.getNext();
            }
        }
    }

    public static void removeDuplicatesFromUnsortedList(SinglyLinkedList list) {
        if (list == null || list.getHead() == null || list.getHead().getNext() == null) {
            return;
        }

        SinglyLinkedList.Node current = list.getHead();
        Set<Integer> seen = new HashSet<>();
        seen.add(current.getData());

        while (current.getNext() != null) {
            if (seen.contains(current.getNext().getData())) {
                current.setNext(current.getNext().getNext());
            } 
            else {
                current = current.getNext();
                seen.add(current.getData());
            }
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertLast(1);
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(2);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        list.insertLast(5);
        list.insertLast(6);
        list.print();

        RemoveDuplicates.removeDuplicatesFromSortedList(list);
        list.print();

        list = new SinglyLinkedList();
        list.insertLast(5);
        list.insertLast(5);
        list.insertLast(2);
        list.insertLast(2);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(1);
        list.insertLast(1);
        list.insertLast(4);
        list.insertLast(6);
        list.print();

        RemoveDuplicates.removeDuplicatesFromUnsortedList(list);
        list.print();
    }
}
