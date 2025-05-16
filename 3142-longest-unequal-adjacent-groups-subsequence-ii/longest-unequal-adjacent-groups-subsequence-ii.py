class Solution:
    def getWordsInLongestSubsequence(self, words: List[str], groups: List[int]) -> List[str]:
        dp = []
        for word, g1 in zip(words, groups):
            dp.append(max((prev for word2, g2, prev in zip(words, groups, dp) 
                    if g1 != g2 and len(word) == len(word2) and sum(map(ne, word, word2)) < 2), key=len, default=[]) + [word])
        
        return max(dp, key=len)
        