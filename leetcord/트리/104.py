# 이진트리의 최대 깊이
# Definition for a binary tree node.
# class TreeNode(object):
#   def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque

class Solution(object):
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        depth = 1
        q = deque([(depth,root)])
        while q:
            depth, node = q.popleft()
            if node != None:
                q.append((depth + 1,node.left))
                q.append((depth + 1,node.right))
        return depth - 1
        
        
root = [3,9,20,null,null,15,7]
print(Solution.maxDepth(root))