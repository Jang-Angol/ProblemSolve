class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        answer = cur = ListNode(0)
        while l1 is not None and l2 is not None:
            if cur.next is None:
                cur.next = ListNode(0)
            cur = cur.next
            value = l1.val + l2.val + cur.val
            cur.val = (value) % 10
            if (value) // 10:
                cur.next = ListNode((value) // 10)
            l1, l2 = l1.next, l2.next
        if cur.next is None:
            if l1 is not None:
                cur.next = l1
            if l2 is not None:
                cur.next = l2
        else:
            while l1 is not None:
                if cur.next is None:
                    cur.next = ListNode(0)
                cur = cur.next
                value = l1.val + cur.val
                cur.val = (value) % 10
                if (value) // 10:
                    cur.next = ListNode((value) // 10)
                l1 = l1.next
            while l2 is not None:
                if cur.next is None:
                    cur.next = ListNode(0)
                cur = cur.next
                value = l2.val + cur.val
                cur.val = (value) % 10
                if (value) // 10:
                    cur.next = ListNode((value) // 10)
                l2 = l2.next
        return answer.next