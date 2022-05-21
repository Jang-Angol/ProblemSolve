# 가장 긴 동일 값의 경로
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    largest_length = 0
    def longestUnivaluePath(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        def dfs(node,prev,length):
            if node == None:
                return
            if node.val != prev:
                length = 0
            self.largest_length = max(self.largest_length,length)
            dfs(node.left,node.val,length)
            dfs(node.right,node.val,length)
        dfs(root,None,0)
        return self.largest_length
