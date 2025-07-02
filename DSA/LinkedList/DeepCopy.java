package DSA.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class DeepCopy {
    public static SinglyLinkedList executeNormal(SinglyLinkedList list) {
        // Map to hold original → copied node mapping
        Map<SinglyLinkedList.Node, CustomNode> map = new HashMap<>();

        // Step 1: Create copy of each node and store in map
        SinglyLinkedList.Node current = list.getHead();
        while (current != null) {
            map.put(current, new CustomNode(current.getData()));
            current = current.getNext();
        }

        // Step 2: Set next and random pointers for each copied node
        current = list.getHead();
        while (current != null) {
            CustomNode nodeCopy = map.get(current);
            nodeCopy.setNext(map.get(current.getNext()));
            
            // No instanceof check needed — all nodes are CustomNode
            CustomNode node = (CustomNode) current;
            nodeCopy.setRandom(map.get(node.getRandom()));
            
            current = current.getNext();
        }

        // Step 3: Return cloned list with correct head
        SinglyLinkedList clone = new SinglyLinkedList();
        clone.setHead(map.get(list.getHead()));
        return clone;
    }

    public static class CustomNode extends SinglyLinkedList.Node {
        private SinglyLinkedList.Node random;

        public CustomNode(int data) {
            super(data);
            this.random = null;
        }

        public void setRandom(SinglyLinkedList.Node random) {
            this.random = random;
        }

        public SinglyLinkedList.Node getRandom() {
            return this.random;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // Step 1: Build the original list with CustomNodes
        Map<Integer, CustomNode> map = new HashMap<>();
        for (int i = 1; i < 10; i++) {
            CustomNode node = new CustomNode(i);
            list.insertLast(node);
            map.put(i, node);
        }

        // Step 2: Set up 'random' pointers
        map.get(1).setRandom(map.get(4));
        map.get(3).setRandom(map.get(1));
        map.get(7).setRandom(map.get(5));

        // Step 3: Print original list before cloning
        list.print();

        // Step 4: Clone the list
        SinglyLinkedList clone = DeepCopy.executeNormal(list);

        // Step 5: Mutate original to verify deep copy integrity
        map.get(1).setData(10);
        map.get(5).setData(50);

        // Step 6: Print original and cloned lists
        System.out.println("\nAfter modifying original list:");
        System.out.println("Original:");
        list.print();
        System.out.println("Cloned:");
        clone.print();
    }
}
