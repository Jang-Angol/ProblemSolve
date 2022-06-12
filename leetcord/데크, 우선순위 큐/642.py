# 원형 데크 디자인
class MyCircularDeque(object):

    def __init__(self, k):
        """
        :type k: int
        """
        self.q = deque([])
        self.size = k
        self.front = 0
        self.rear = 0

    def insertFront(self, value):
        """
        :type value: int
        :rtype: bool
        """
        if self.isFull():
            return False
        else:
            if not self.isEmpty():
                self.front -= 1
                if self.front == -1:
                    self.front = self.size
            self.q.appendleft(value)
            return True

    def insertLast(self, value):
        """
        :type value: int
        :rtype: bool
        """
        if self.isFull():
            return False
        else:
            if not self.isEmpty():
                self.rear = (self.rear+1) % self.size
            self.q.append(value)
            return True

    def deleteFront(self):
        """
        :rtype: bool
        """
        if self.isEmpty():
            return False
        else:
            self.q.popleft()
            if self.q:
                self.front = (self.front+1) % self.size
            return True

    def deleteLast(self):
        """
        :rtype: bool
        """
        if self.isEmpty():
            return False
        else:
            self.q.pop()
            if self.q:
                self.rear -= 1
                if self.rear == -1:
                    self.rear = self.size - 1
            return True

    def getFront(self):
        """
        :rtype: int
        """
        if self.isEmpty():
            return -1
        return self.q[0]

    def getRear(self):
        """
        :rtype: int
        """
        if self.isEmpty():
            return -1
        return self.q[-1]

    def isEmpty(self):
        """
        :rtype: bool
        """
        return not self.q

    def isFull(self):
        """
        :rtype: bool
        """
        return len(self.q) == self.size


# Your MyCircularDeque object will be instantiated and called as such:
# obj = MyCircularDeque(k)
# param_1 = obj.insertFront(value)
# param_2 = obj.insertLast(value)
# param_3 = obj.deleteFront()
# param_4 = obj.deleteLast()
# param_5 = obj.getFront()
# param_6 = obj.getRear()
# param_7 = obj.isEmpty()
# param_8 = obj.isFull()
