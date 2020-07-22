'''
Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

 

Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

 

Note: 

    1 <= preorder.length <= 100
    The values of preorder are distinct.

'''

# Just create a Binary search tree from the input.
class Solution:
    def bstFromPreorder(self, preorder: List[int]) -> TreeNode:
        root = TreeNode(preorder[0])
        def insertele(target, node):
            while True:
                if node.val > target:
                    if node.left == None:
                        node.left = TreeNode(target)
                        break
                    else:
                        node = node.left
                else :
                    if node.right == None:
                        node.right = TreeNode(target)
                        break
                    else:    
                        node=node.right
        for i in range(1,len(preorder)):
            insertele(preorder[i],root)
        return root
            
