package linked_lists;
/**
 * 
 * 2.4
 * Partition: Write code to partition a linked list around a value x, such that all nodes 
 * less than x come before all nodes greater than or equal to x. If x is contained within 
 * the list, the values of x only need to be after the elements less than x. The partition
 * element x can appear anywhere in the "right partition"; it does not need to appear b/w
 * the left and right partitions.
 * 
 * EXAMPLE
 * Input:  3->5->8->5->10->2->1
 * output: 3->1->2->10->5->5->8
 * 
 */
public class Partition {
    // Doesn't change the head, but solves the rest of the problem in a stable manner
    // public void makePartition(Node<Integer> head, int k) {
    //     Node<Integer> p1=head, p2=head, last=head;
    //     while(p1 != null) {
    //         if(p1.data<k) {
    //             if(p1.equals(p2)) {
    //                 last = p1;
    //                 p1 = p1.next;
    //             } else {
    //                 last.next = p1.next;
    //                 p1.next = p2.next;
    //                 p2.next = p1;
    //                 p2 = p2.next;
    //                 p1 = last.next;
    //             }
    //         } else {
    //             last = p1;
    //             p1 = p1.next;
    //         }
    //     }
    // }

    // changes the head and thus we have to return it.
    // approach is not stable, adds elements less than key to head and greater than key to tail
    public Node<Integer> makePartition(Node<Integer> head, int k) {
        Node<Integer> p1=head, tail=head, temp = null;
        while(p1 != null) {
            temp = p1;
            if(p1.data < k) {
                p1 = p1.next;
                temp.next = head;
                head = temp;
            } else {
                p1 = p1.next;
                tail.next = temp;
                tail = temp;
            }
        }
        tail.next = null;
        return head;
    }
}