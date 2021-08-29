package CtCI.java.linked_lists;
import java.util.*;

/**
 * 2.1
 * Remove Dups: Write code to remove duplicates from an unsorted linked list.
 * Follow up
 * How would you solve this problem is a temporary buffer is not allowed.
 */

public class RemoveDups {
    public void remove(Node<Character> head) {
        if(head==null) return ;
        Set<Character> set = new HashSet<Character>();
        Node<Character> pt,prev;
        prev = head;
        set.add(head.data);
        pt= head.next;
        while(pt!=null){
            if(set.contains(pt.data)) {
                prev.next = pt.next;
                pt.next = null;
            }
            else {
                set.add(pt.data);
            }
            prev = prev.next;
            pt = prev.next;
        }
    }
}