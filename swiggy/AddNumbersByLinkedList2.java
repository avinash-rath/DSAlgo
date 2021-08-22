package swiggy;

/**
 * Add two numbers represented by linked lists | Set 2
Difficulty Level : Hard
Given two numbers represented by two linked lists, write a function that returns the sum list. The sum list is linked list representation of the addition of two input numbers. It is not allowed to modify the lists. Also, not allowed to use explicit extra space (Hint: Use Recursion).

Example :

Input:
  First List: 5->6->3  
  Second List: 8->4->2 
Output
  Resultant list: 1->4->0->5
 */

class AddNumbersByLinkedList2 {
    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            next = null;
        }
        
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    int carry, diff;

    public Node add(Node num1, Node num2) {
        carry = 0;
        int lenNum1 = countLength(num1);
        int lenNum2 = countLength(num2);
        if(lenNum1 < lenNum2) {
            Node temp = num1;
            num1 = num2;
            num2 = temp;
        }
        diff = Math.abs(lenNum1 - lenNum2);
        Node result = recursionHelper(num1, num2);
        Node last = result;
        if(carry > 0) {
            last = new Node(carry);
            last.next = result;
            carry = 0;
        }
        return last;
    }

    public Node recursionHelper(Node num1, Node num2) {
        if(num1 == null || num2 == null) {
            return null;
        }
        int curr;
        Node result;
        if(diff > 0) {
            diff--;
            result = recursionHelper(num1.next, num2);
            curr = num1.val + carry;
            
        } else {
            result = recursionHelper(num1.next, num2.next);
            curr = num1.val + carry + num2.val;
        }
        if(curr > 9) {
            carry = curr / 10;
            curr = curr % 10;
        } else {
            carry = 0;
        }
        Node newNode = new Node(curr);
        newNode.next = result;
        return newNode;

    }

    public int countLength(Node list) {
        Node node = list;
        int length = 0;
        while(node != null) {
            length++;
            node = node.next;
        }
        return length;
    }
    public static void printList(Node num) {
        Node node = num;
        while(node != null) {
            System.out.print(node.val+" ");
            node = node.next;
        }
    }
    public void operate() {
        Node num1 = new Node(5, new Node(6, new Node(3)));
	    Node num2 = new Node(8, new Node(4));
	    printList(add(num1,num2));
    }
}