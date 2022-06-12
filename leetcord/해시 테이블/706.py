# 해시뱀 디자인
class ListNode:
    def __init__(self, key=None, value=None):
        self.key = key
        self.value = value
        self.next = None


class MyHashMap(object):

    def __init__(self):
        self.size = 10000
        self.table = collections.defaultdict(ListNode)

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        index = key % self.size

        if self.table[index].value is None:
            self.table[index] = ListNode(key, value)
            return
        else:
            node = self.table[index]
            while node:
                if node.key == key:
                    node.value = value
                    return
                if node.next is None:
                    break
                node = node.next
            node.next = ListNode(key, value)
            return

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        index = key % self.size
        if self.table[index].value is None:
            return -1

        node = self.table[index]
        while node:
            if node.key == key:
                return node.value
            node = node.next
        return -1

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        index = key % self.size
        if self.table[index].value is None:
            return
        node = prev = self.table[index]
        if node.key == key:
            self.table[index] = ListNode() if node.next is None else node.next
            return
        node = node.next
        while node:
            if node.key == key:
                prev.next = ListNode() if node.next is None else node.next
                return
            prev, node = node, node.next

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
