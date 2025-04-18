class Solution(object):
    def countAndSay(self, n):
        ret = "1"
        for _ in range(n-1):
            ret = self.nextStep(ret)
        return ret
    
    def nextStep(self, s):
        i, ret = 0, ""
        while i < len(s):
            count = 1
            while i+1 < len(s) and s[i+1] == s[i]:
                count += 1
                i += 1
            ret += str(count) + s[i]
            i += 1
        return ret
    
    def countAndSay1(self, n):
        if n == 1:
            return "1"
        s = self.countAndSay(n-1)
        i, ret = 0, ""
        while i < len(s):
            count = 1
            while i+1 < len(s) and s[i+1] == s[i]:
                count += 1
                i += 1
            ret += str(count) + s[i]
            i += 1
        return ret