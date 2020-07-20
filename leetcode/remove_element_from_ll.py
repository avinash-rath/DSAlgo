'''
Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
'''


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeElements(self, head: ListNode, val: int) -> ListNode:
        while head:
          if head.val != val : break
          head = head.next
        node = head
        prev = head
        while node:
          if node.val == val:
            prev.next = node.next
            node = prev.next
          else:
            prev = node
            node = node.next
        return head
