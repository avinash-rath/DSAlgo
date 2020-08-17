package linked_lists;

import java.util.HashSet;
import java.util.Set;

/**
 * 2.7
 * 
 * Intersection: Given two (singly) linked lists, determin if the wo lists intersect.
 * Return the intersecting node. Note that the intersection is defined based on reference,
 * not value. That is, ig kth node of the first linked list is the exact same node(by ref)
 * as the jth node of the second linked list, then they are intersecting.
 * 
 */

public class Intersection<T> {
    public Node<T> isIntersecting(Node<T> head1, Node<T> head2) {
        Node<T> n1 = head1,n2 = head2, last1=null, last2=null, ans = null;
        int len1 = 0, len2 = 0, diff;
        while(n1!=null) { last1 = n1; n1 = n1.next; len1++; }
        n1 = head1;
        n2 = head2;
        while(n2!=null) { last2 = n2; n2 = n2.next; len2++; }
        n2 = head2;

        // if the tails are not same, they are not intersecting
        if(!last1.equals(last2)) return null;  

        // obtain the difference in lengths and move the pointer from head(of the longer LL)
        // by the diff amount.
        diff = len1-len2;
        if(diff>0) {
            while(diff>0) {
                n1 = n1.next; diff--;
            }
        } else if (diff < 0) {
            while(diff<0) { n2 = n2.next; diff++; }
        }

        // check when two nodes are same;
        while(n1!=null) {
            if(n1==n2) {ans = n1; break;}
            n1 = n1.next; n2 = n2.next;
        }
        return ans;
    }
    // using hashset, not the best solution, however isn't inefficient as we are only storing 
    // references and not the complete objects
    public Node<T> usingHashSet(Node<T> head1, Node<T> head2) {
        Set<Node<T>> set = new HashSet<Node<T>>();
        Node<T> n = head1;
        while(n!= null) {
            set.add(n);
            n = n.next;
        }
        n = head2;
        while(n!= null) {
            if(set.contains(n)) return n;
            n = n.next;
        }
        return null;
    }
}