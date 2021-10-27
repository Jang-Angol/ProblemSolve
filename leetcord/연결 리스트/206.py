# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        answer = cur = ListNode()
        stack = []
        while head is not None:
            stack.append(head.val)
            head = head.next
        while stack:
            cur.next = ListNode(stack.pop())
            cur = cur.next
        return answer.next