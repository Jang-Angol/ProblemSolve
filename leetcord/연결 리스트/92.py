class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        answer = cur = ListNode(0)
        temp = deque([])
        i = 1
        while head:
            while left <= i and i <= right:
                temp.append(head.val)
                head = head.next
                i += 1
            while temp:
                cur.next = ListNode(temp.pop())
                cur = cur.next
            cur.next = ListNode(head.val)
            if head:
                cur = cur.next
                head = head.next
                i += 1
        return answer.next