package linked_lists;
/**
 * 2.5 
 * Sum Lists: You have two numbers represented by a linked list, where each node contains a single digit. 
 * The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a 
 * function that adds the two numbers and returns the sum as linked list.
 * 
 * EXAMPLE
 * 
 * Input: (7 -> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295.
 * Output: 2-> 1-> 9. That is, 912
 * 
 */
public class SumLists {
    // an easy approach is to convert the LLs to numbers and create LLs from the sum. 
    // But that is not really what an interviewer may be looking for

    // The following approach recursively visits each node until end of each list is obtained(can be of 
    // different length) and return a new LL as the answer.
    public Node<Integer> sum(Node<Integer> head1, Node<Integer> head2) {
        Node<Integer> ans = new Node<Integer>();
        if(head1 == null) return head2;
        if(head2 == null) return head1;
        
        ans.data = (head1.data + head2.data)%10;
        ans.next = sum(head1.next, head2.next, (head1.data + head2.data)/ 10);
        return ans;
    }
    public Node<Integer> sum(Node<Integer> head1, Node<Integer> head2, int carry) {
        if(head1==null && head2 == null) {
            if(carry == 0) return null;
            return new Node<Integer>(carry);
        }
        Node<Integer> ans = new Node<Integer>();
        int add = (head1 == null ? 0 : head1.data) + (head2 == null ? 0 : head2.data) + carry;
        ans.data = add % 10;
        ans.next = sum(head1 == null ? head1 : head1.next, head2 == null ? head2 : head2.next, add / 10);
        return ans;
    }
}