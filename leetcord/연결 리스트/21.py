# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def mergeTwoLists(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        answer = cur = ListNode()
        node1 = l1
        node2 = l2
        while node1 is not None and node2 is not None:
            if node1.val > node2.val:
                node = ListNode(node2.val)
                node2 = node2.next
            else:
                node = ListNode(node1.val)
                node1 = node1.next
            cur.next = node
            cur = cur.next

        while node1 is not None:
            node = ListNode(node1.val)
            node1 = node1.next
            cur.next = node
            cur = cur.next

        while node2 is not None:
            node = ListNode(node2.val)
            node2 = node2.next
            cur.next = node
            cur = cur.next
        
        return answer.next
    """
    # 재귀(recursive)
    def mergeTwoLists(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        if (not l1) or (l2 and l1.val > l2.val):
            l1, l2 = l2, l1
        if l1: 
            l1.next = self.mergeTwoLists(l1.next, l2)
        return l1
    """ 