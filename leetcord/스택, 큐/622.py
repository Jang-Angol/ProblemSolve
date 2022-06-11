# 원형 큐 디자인
class MyCircularQueue(object):
    
    def __init__(self, k):
        """
        :type k: int
        """
        self.size = k
        self.q = [None for _ in range(k)]
        self.front = 0
        self.rear = 0

    def enQueue(self, value):
        """
        :type value: int
        :rtype: bool
        """
        if self.isFull():
            return False
        else:
            if not self.isEmpty():
                self.rear = (self.rear+1)%self.size
            self.q[self.rear] = value
            return True

    def deQueue(self):
        """
        :rtype: bool
        """
        if self.isEmpty():
            return False
        else:
            self.q[self.front] = None
            if not self.isEmpty():
                self.front = (self.front+1)%self.size
            return True

    def Front(self):
        """
        :rtype: int
        """
        if self.q[self.front] == None:
            return -1
        else:
            return self.q[self.front]

    def Rear(self):
        """
        :rtype: int
        """
        if self.q[self.rear] == None:
            return -1
        else:
            return self.q[self.rear]

    def isEmpty(self):
        """
        :rtype: bool
        """
        return self.rear == self.front and self.q[self.front] == None
        

    def isFull(self):
        """
        :rtype: bool
        """
        return (self.rear+1)%self.size == self.front and self.q[self.front] != None


# Your MyCircularQueue object will be instantiated and called as such:
# obj = MyCircularQueue(k)
# param_1 = obj.enQueue(value)
# param_2 = obj.deQueue()
# param_3 = obj.Front()
# param_4 = obj.Rear()
# param_5 = obj.isEmpty()
# param_6 = obj.isFull()