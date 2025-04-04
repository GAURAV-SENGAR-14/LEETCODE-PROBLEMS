# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def lcaDeepestLeaves(self, root: TreeNode) -> TreeNode:
        def post_order(root):
            if not root:
                return 0, None
            d1, n1 = post_order(root.left)
            d2, n2 = post_order(root.right)
            if d1 == d2:
                return d1+1, root
            elif d1 > d2:
                return d1+1, n1
            else:
                return d2+1, n2
            
        d, n = post_order(root)
        return n