/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<List<Integer>>();
        }
        int level = 0;
        List<Integer> currLevel;
        Map<Integer, List<Integer>> levels = new HashMap<Integer, List<Integer>>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        level(root, levels, level);
        for(List<Integer> list: levels.values()) {
            ans.add(list);
        }
        return ans;
    }
    
    public void level(TreeNode root, Map<Integer, List<Integer>> levels, int level){
        List<Integer> currLevel = levels.get(level);
        if(currLevel == null) {
            currLevel = new ArrayList<Integer>();
            currLevel.add(root.val);
            levels.put(level,currLevel);
        } else {
            if(level%2 != 0) {
                currLevel.add(0,root.val);
            } else {
                currLevel.add(root.val);
            }
            levels.put(level, currLevel);
        }
        if(root.left != null) {
            level(root.left,levels,level+1);
        }
        if(root.right != null) {
            level(root.right, levels, level+1);
        }
        
    }
}