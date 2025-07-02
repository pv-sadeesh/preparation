package DSA.LinkedList;

public class PalindromeChecker {
    public static boolean isPalindrome(SinglyLinkedList list) {
        // Edge case: empty list or single node list is always a palindrome
        if (list == null || list.getHead() == null || list.getHead().getNext() == null) {
            return true;
        }

        // Step 1: Use slow and fast pointers to find the midpoint of the list
        SinglyLinkedList.Node slow = list.getHead();
        SinglyLinkedList.Node fast = list.getHead();
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        // Step 2: Reverse the second half of the list starting from the midpoint
        SinglyLinkedList.Node firstHalf = list.getHead();
        SinglyLinkedList.Node secondHalf = reverse(slow);
        SinglyLinkedList.Node secondHalfCopy = secondHalf; // For restoring later
        
        // Step 3: Compare first and second halves
        while (secondHalf != null) {
            if (secondHalf.getData() != firstHalf.getData()) {
                // Mismatch found — restore the list before returning
                reverse(secondHalfCopy);
                return false;
            }

            firstHalf = firstHalf.getNext();
            secondHalf = secondHalf.getNext();
        }

        // Step 4: Restore the second half to its original order
        reverse(secondHalfCopy);

        // Step 5: All values matched — it is a palindrome
        return true;
    }

    private static SinglyLinkedList.Node reverse(SinglyLinkedList.Node head) {
        SinglyLinkedList.Node current = head;
        SinglyLinkedList.Node previous = null;

        while (current != null) {
            SinglyLinkedList.Node next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }

        return previous;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(2);
        list.insertLast(1);

        System.out.println("\n");
        list.print();
        System.out.println("IsPalindrome: " + PalindromeChecker.isPalindrome(list));
        list.print();

        list = new SinglyLinkedList();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(2);
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(2);

        System.out.println("\n");
        list.print();
        System.out.println("IsPalindrome: " + PalindromeChecker.isPalindrome(list));
        list.print();

        list = new SinglyLinkedList();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(2);
        list.insertLast(1);

        System.out.println("\n");
        list.print();
        System.out.println("IsPalindrome: " + PalindromeChecker.isPalindrome(list));
        list.print();
    }
}
