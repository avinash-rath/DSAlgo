package leetcode.java;


/**
 * Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.

 

Example 1:


Input: root = [5,3,6,2,4,null,7], k = 9
Output: true
Example 2:


Input: root = [5,3,6,2,4,null,7], k = 28
Output: false
Example 3:

Input: root = [2,1,3], k = 4
Output: true
Example 4:

Input: root = [2,1,3], k = 1
Output: false
Example 5:

Input: root = [2,1,3], k = 3
Output: true
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-104 <= Node.val <= 104
root is guaranteed to be a valid binary search tree.
-105 <= k <= 105
 */

public class TwoSumIVBST {
    // BFS Solution, doesn't take advantage of the BST.
    // public boolean findTarget(TreeNode root, int k) {
    //     Set<Integer> set = new HashSet<>();
    //     TreeNode node = root;
    //     Queue<TreeNode> q = new LinkedList<>();
    //     q.add(node);
    //     while(q.size() > 0) {
    //         node = q.poll();
    //         if(set.contains(k-node.val)) {
    //             return true;
    //         }
    //         set.add(node.val);
    //         if(node.left != null) q.add(node.left);
    //         if(node.right != null) q.add(node.right);
    //     }
    //     return false;
    // }
    private TreeNode search(TreeNode root, int k) { 
        // search for k(compliment in the tree)
        if(root == null) return null;
        if(k == root.val) return root;
        if(k < root.val) {
            return search(root.left, k);
        }
        return search(root.right, k);
    }
    
    private boolean find(TreeNode root, TreeNode dummyRoot, int k) { 
        // for an element (root) use (dummyRoot) to find out the compliment using search method
        if(root == null) return false;
        
        TreeNode res = search(dummyRoot, k - root.val);
        if(res != null && res != root) return true;
        
        // if not found, go for left and right children.
        return find(root.left, dummyRoot, k) || find(root.right, dummyRoot, k);
    }
    
    public boolean findTarget(TreeNode root, int k) {
        return find(root, root, k);
    }
}
