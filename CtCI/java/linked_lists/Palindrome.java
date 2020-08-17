package linked_lists;

import java.util.Stack;

public class Palindrome {
    public boolean isPalindrome(Node<Character> head) {
        Stack<Character> stack = new Stack<Character>();
        Node<Character> n = head;
        int len = 0, runner = 1;
        while(n != null) {
            len++; n = n.next;
        }
        System.out.println(len);
        n = head;
        while(runner <= len) {
            if(runner == ((len/2)+1) && len%2 != 0) {
                // do nothing
            } 
            else if(runner > len/2) {
                if(stack.pop() != n.data) {return false;}
            }
            // skip one char in middle if the length of LL is odd
            // add half of LL to stack
            else stack.add(n.data); 
            runner++; 
            n = n.next;
        }

        return true;
    }
}