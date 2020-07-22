'''
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6

Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42


'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: TreeNode) -> int:
        self.m = -float('inf')
        def fn(node: TreeNode):
            left = fn(node.left) if node.left else 0
            right = fn(node.right) if node.right else 0
            m = max(0,max(left,right)) + node.val
            currsum = max(left+right+node.val, m)
            self.m = max(self.m,currsum)
            return m
        fn(root)
        return self.m
