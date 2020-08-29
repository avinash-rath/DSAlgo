/*
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
*/



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  int sum = 0;
  public int sumOfLeftLeaves(TreeNode root) {
    util(root, false);
    return sum;
  }
   private void util(TreeNode node, boolean isLeft) {
     if(node == null) return;
     sum += (node.left == null && node.right == null && isLeft) ? node.val : 0;
     util(node.left, true);
     util(node.right, false);
   }
}
