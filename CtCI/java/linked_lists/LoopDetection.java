package CtCI.java.linked_lists;

import java.util.*;

/**
 * 2.8
 * Loop Detection: Given a circular linked list, implement an algorithm that returns the node at
 * the beginning of the loop.
 * 
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an 
 * earlier node, as to make a loop in the linked list.
 * 
 * EXAMPLE
 * 
 * Input: A -> B -> C -> D -> E -> C (the same C as earlier)
 * Output: C
 * 
 */

public class LoopDetection<T> {

    public Node<T> detect(Node<T> head) {
        Node<T> slow = head, fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }

        if(fast==null || fast.next==null) return null;

        slow = head;

        while(slow!=fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
    // Using hashset for implementing the solution.
    public Node<T> usingHashSet(Node<T> head) {
        Set<Node<T>> set = new HashSet<Node<T>>();
        Node<T> n = head;
        while(n!=null && !set.contains(n)){
            set.add(n); n = n.next;
        }
        return n;
    }
}