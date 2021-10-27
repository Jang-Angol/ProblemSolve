from collections import deque
# Definition for singly-linked list.
class ListNode:
     def __init__(self, val=0, next=None):
         self.val = val
         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        q = deque([])

        if not head:
            return True

        node = head

        while node is not None:
            q.append(node.val)
            node = node.next
        
        while len(q) > 1:
           if q.popleft() != q.pop():
                return False
        
        return True
        """
        # 런너 기법
        # 두개의 포인터를 다른 속도로 이동 시킴
        rev = None
        slow = fast = head
        # 런너를 이용해 역순 연결 리스트 구성
        while fast and fast.next:
            fast = fast.next.next
            rev, rev.next, slow = slow, rev, slow.next
        if fast:
            slow = slow.next
        
        # 팰린드롬 여부 확인
        while rev and rev.val == slow.val:
            slow, rev = slow.next, rev.next
        return not rev
        """