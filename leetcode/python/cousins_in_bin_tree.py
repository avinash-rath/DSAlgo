'''
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

 

Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:



Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 

Note:

The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.
'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        self.parentX = None
        self.parentY = None
        self.xDepth = 0
        self.yDepth = 0
        
        def dfs(node: TreeNode, x: int, y:int, depth: int):
          if self.parentX and self.parentY:
            return
          if node.left: 
            if x == node.left.val:
              self.parentX = node
              self.xDepth = depth + 1
            if y == node.left.val:
              self.parentY = node
              self.yDepth = depth + 1
            dfs(node.left, x, y, depth+1)
          if node.right:
            if y == node.right.val:
              self.parentY = node
              self.yDepth = depth + 1
            if x == node.right.val:
              self.parentX = node
              self.xDepth = depth + 1
            dfs( node.right, x, y, depth+1 )
        dfs(root, x, y, 0)
        if self.parentX == self.parentY or (self.xDepth != self.yDepth):
          return False
        return True
            
