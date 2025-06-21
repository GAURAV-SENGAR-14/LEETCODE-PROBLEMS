from collections import Counter
class Solution:
    def minimumDeletions(self, word: str, k: int) -> int:
        babu = list(Counter(word).values())
        mn = float('inf')
        
        for i in range(1, max(babu)+1):
            temba = 0
            for f in babu:
                if f < i:
                    temba += f
                elif f > i + k:
                    temba += f - (i + k)
            mn = min(mn, temba)
        
        return mn
            