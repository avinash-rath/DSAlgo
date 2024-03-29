package leetcode.java;

import java.util.LinkedList;
import java.util.List;

/*
Given two binary search trees root1 and root2.

Return a list containing all the integers from both trees sorted in ascending order.

 

Example 1:

Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]

Example 2:

Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
Output: [-10,0,0,1,2,5,7,10]

Example 3:

Input: root1 = [], root2 = [5,1,7,0,2]
Output: [0,1,2,5,7]

Example 4:

Input: root1 = [0,-10,10], root2 = []
Output: [-10,0,10]

Example 5:

Input: root1 = [1,null,8], root2 = [8,1]
Output: [1,1,8,8]

 

Constraints:

    Each tree has at most 5000 nodes.
    Each node's value is between [-10^5, 10^5].


*/
class AllElementsIn2BST {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        LinkedList<Integer> t1, t2, ans;
        t1 = new LinkedList<Integer>();
        t2 = new LinkedList<Integer>();
        ans = new LinkedList<Integer>();
        inOrder(root1, t1);
        inOrder(root2, t2);
        while(!t1.isEmpty() && !t2.isEmpty()) {
            if(t1.peekFirst() <= t2.peekFirst()) {
                ans.add(t1.pollFirst());
            } else {
                ans.add(t2.pollFirst());
            }
        }
        if(!t1.isEmpty()) {
            ans.addAll(t1);
        }
        if(!t2.isEmpty()) ans.addAll(t2);
        
        return ans;
    }
    
    private void inOrder(TreeNode root, List<Integer> list) {
        if(root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}

/*
// A bit slow solution using Collections.sort()
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> t1, t2, ans;
        t1 = new ArrayList<Integer>();
        t2 = new ArrayList<Integer>();
        // ans = new ArrayList<Integer>();
        inOrder(root1, t1);
        inOrder(root2, t2);
        t1.addAll(t2);
        Collections.sort(t1);
        return t1;
    }
    
    private void inOrder(TreeNode root, List<Integer> list) {
        if(root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
*/
