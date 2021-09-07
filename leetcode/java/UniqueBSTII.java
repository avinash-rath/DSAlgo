package leetcode.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.

 

Example 1:


Input: n = 3
Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
Example 2:

Input: n = 1
Output: [[1]]
 

Constraints:

1 <= n <= 8
 */


// THIS IS A GOOD ONE 
public class UniqueBSTII {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1,n);
    }
    
    public List<TreeNode> generateTrees(int start, int end) {
        // creates a subtree of elements [start,end]
        List<TreeNode> allTrees = new ArrayList<>();
        
        if(start > end) {
            allTrees.add(null);
            return allTrees;
        }
        
        for(int i = start; i <= end; i++) {
            // generating left and right subtrees considering current root as i;
            
            // to follow the BST rule, left subtrees should contain the values smaller than i,
            // which would mean that it should only contain values [start, i - 1]
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            
            // similarly, right subtrees must contain values greater than i,
            // which would mean that it should generate subtrees containing [i+1, end]
            List<TreeNode> rightTrees = generateTrees(i+1, end); 
            
            for(TreeNode l : leftTrees) {
                for(TreeNode r: rightTrees) {
                    // add all the left and right subtrees to thed current node and save it
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    allTrees.add(node);
                }
            }
        }
        return allTrees;
        
    }
}
