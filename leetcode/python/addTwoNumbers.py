# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
#You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
#
#You may assume the two numbers do not contain any leading zero, except the number 0 itself.
#
#Example:
#
#Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
#Output: 7 -> 0 -> 8
#Explanation: 342 + 465 = 807.
#Difficulty - medium

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        val1 = ""
        while l1!=None:
            val1 += str(l1.val)
            l1 = l1.next
        val1 = int(val1[::-1]) if val1 !="" else 0
        val2 = ""
        while l2!=None:
            val2 += str(l2.val)
            l2 = l2.next
        val2 = int(val2[::-1]) if val2 !="" else 0
        num = val1 + val2
        num = str(num)
        num = num[::-1]
        print(val1,val2,num)
        currNode = None
        headNode = ListNode(num[0])
        prevNode = headNode
        for i in range(1,len(num)):
            currNode = ListNode(num[i])
            prevNode.next = currNode
            prevNode = currNode
        return headNode
    
