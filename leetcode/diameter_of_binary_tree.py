'''
543. Diameter of Binary Tree
Easy

Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree

          1
         / \
        2   3
       / \     
      4   5    

Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them. 
'''

## initial submission. Extremely slow.
# approach : checking left and right heights of each node and storing it preorder.
#            And then checking for the greatest sum of right and left heights 
#            that gives the diameter

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
        self.mylist = []
    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        self.preorder(root)
        highest = 0
        for i in self.mylist:
            highest = max(highest,i['left']+i['right'])
        return highest-1 if highest > 0 else highest

        
    def preorder(self,node):
        if node:
            self.mylist.append(self.height(node))
            self.preorder(node.left)
            self.preorder(node.right)
        
    def height(self,node):
        if node is None:
            return {'left':0,'right':0}
        else:
            lst = self.height(node.left)
            lheight = max(lst['left'],lst['right'])
            rst = self.height(node.right)
            rheight = max(rst['left'],rst['right'])

            if lheight > rheight : 
                return {'left':lheight+1,'right':rheight}
            else: 
                return {'left':lheight,'right':rheight+1}
                
                
'''
# DFS method of solving. Similar approach. 
class Solution:
    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        self.ans = 1
        def depth(node):
            if not node: return 0
            L = depth(node.left)
            R = depth(node.right)
            self.ans = max(self.ans, L+R+1)
            return max(L, R) + 1

        depth(root)
        return self.ans - 1
'''
