package DSA.LinkedList;

public class Intersection {
    public static SinglyLinkedList.Node find(SinglyLinkedList list1, SinglyLinkedList list2) {
        // Alternative Approaches to Find Linked List Intersection:

        // 1. Using HashSet:
        //    - Traverse the first list and insert each node into a HashSet.
        //    - Then traverse the second list and check if any node already exists in the set.
        //    Time: O(m + n), Space: O(m) — where m is the length of list1.

        // 2. Using Length Alignment:
        //    - First, calculate the lengths of both lists.
        //    - Advance the pointer of the longer list by the length difference.
        //    - Then traverse both lists in tandem until the intersection node is found (by reference).
        //    Time: O(m + n), Space: O(1)

        if (list1 == null || list2 == null) {
            return null;
        }

        SinglyLinkedList.Node current1 = list1.getHead();
        SinglyLinkedList.Node current2 = list2.getHead();

        while (current1 != current2) {
            current1 = (current1 == null ? list2.getHead() : current1.getNext());
            current2 = (current2 == null ? list1.getHead() : current2.getNext());
        }

        return current1;
    }
}
