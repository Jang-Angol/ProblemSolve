# 이진트리의 직경
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def diameterOfBinaryTree(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        answer = [0,0]
        def dfs(d,depth,node):
            if node == None:
                answer[d] = max(answer[d],depth)
                return
            dfs(d,depth + 1, node.left)
            dfs(d,depth + 1, node.right)
        dfs(0,answer[0],root.left)
        dfs(1,answer[1],root.right)
        return sum(answer)