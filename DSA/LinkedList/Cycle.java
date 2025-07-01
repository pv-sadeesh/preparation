package DSA.LinkedList;

public class Cycle {
    public static boolean exists(SinglyLinkedList list) {
        // Handle edge cases: empty list or single-node list
        if (list == null || list.getHead() == null || list.getHead().getNext() == null) {
            return false;
        } 

        SinglyLinkedList.Node slow = list.getHead();
        SinglyLinkedList.Node fast = list.getHead();

        // Step 1: Detect cycle using Floyd's Algorithm (Tortoise and Hare)
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if (slow == fast) {
                // Step 2: Cycle detected
                return true;
            }
        }

        return false;
    }

    public static int length(SinglyLinkedList list) {
        // Handle edge cases: empty list or single-node list
        if (list == null || list.getHead() == null || list.getHead().getNext() == null) {
            return 0;
        }

        SinglyLinkedList.Node slow = list.getHead();
        SinglyLinkedList.Node fast = list.getHead();

        // Step 1: Detect cycle using Floyd's Algorithm (Tortoise and Hare)
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if (slow == fast) {
                // Step 2: Cycle detected
                int length = 0;
                SinglyLinkedList.Node current = slow;  
                
                // Step 3: Count its length
                do {
                    current = current.getNext();
                    length++;
                } while (current != slow);

                return length;
            }
        }

        return 0;
    }

    public static SinglyLinkedList.Node start(SinglyLinkedList list) {
        // Handle edge cases: empty list or single-node list
        if (list == null || list.getHead() == null || list.getHead().getNext() == null) {
            return null;
        }

        SinglyLinkedList.Node slow = list.getHead();
        SinglyLinkedList.Node fast = list.getHead();

        // Step 1: Detect cycle using Floyd's Algorithm (Tortoise and Hare)
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            // Step 2: Cycle detected
            if (slow == fast) {
                // Step 3: Find start of loop
                // Both pointers are now k steps from loop start, moving 1 step each will meet at the start
                SinglyLinkedList.Node entry = list.getHead();
                while (entry != slow) {
                    entry = entry.getNext();
                    slow = slow.getNext();
                }
                return entry;
            }
        }

        return null;
    }
}
