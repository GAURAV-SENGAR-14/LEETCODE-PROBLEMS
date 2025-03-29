class Solution(object):
    def longestCommonPrefix(self, strs):
        if len(strs) == 0:
            return ''
        ans = strs[0]
        for i in range(1, len(strs)):
            while ans != strs[i][:len(ans)]:
                ans = ans[:-1]
                if ans == '':
                    return ''
        return ans