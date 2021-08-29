package CtCI.java.linked_lists;
/**
 * 2.2
 * Return kth to last : Implement an algorithm to implement kth to last element of a singly linked list.
 * 
 * Z
 */
public class KthToLast<T> {
    // Simple approach of finding the length and then searching (length - k)th element
    // public T returnKth(Node<T> head, int k) {
    //     int len = 0;
    //     Node<T> p = head;
    //     while(p!=null) {
    //         len++;
    //         p = p.next;
    //     }
    //     p = head;
    //     int count = 1;
    //     while(count<(len-k+1)) {
    //         count++;
    //         p = p.next;
    //     }
    //     return p.data;
    // }

    // still O(n) but lesser number of iterations in average case
    public T returnKth(Node<T> head, int k) {
        Node<T> p1 = head, p2 = head;
        while(k>0) {
            try{
                p2 = p2.next;
                k--;
            } catch(Exception e) {
                System.out.println("exception");
                return new Node<T>().data;
            }

        }
        while(p2!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1 == null ? null : p1.data;
    }
}