def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
    answer = cur = ListNode(0)
    odd, even = 0,0
    if head:
        odd = odd_cur = ListNode(head.val)
        head = head.next
    if head:
        even = even_cur = ListNode(head.val)
        head = head.next
    while head:
        if head:
            odd_cur.next = ListNode(head.val)
            odd_cur = odd_cur.next
            head = head.next
        if head:
            even_cur.next = ListNode(head.val)
            even_cur = even_cur.next
            head = head.next
    if odd:
        answer.next = odd
    if even:
        odd_cur.next = even

    return answer.next