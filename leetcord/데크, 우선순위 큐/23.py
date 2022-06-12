# k개 정렬 리스트 병합
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        head = cur = ListNode()
        q = []
        for l in lists:
            node = l
            while node:
                heapq.heappush(q, node.val)
                node = node.next
        while q:
            val = heapq.heappop(q)
            cur.next = ListNode(val)
            cur = cur.next
        return head.next
