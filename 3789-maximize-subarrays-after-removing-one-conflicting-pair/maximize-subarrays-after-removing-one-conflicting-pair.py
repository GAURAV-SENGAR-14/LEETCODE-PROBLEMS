class Solution:
    def maxSubarrays(self, n: int, conflictingPairs: List[List[int]]) -> int:
        rights: list[list[int]] = [[] for _ in range(n + 1)]
        for a, b in conflictingPairs:
            rights[max(a, b)].append(min(a, b))
        output: int = 0
        left: list[int] = [0, 0]
        bonus: list[int] = [0] * (n + 1)
        for right in range(1, n + 1):
            for l in rights[right]:
                if l > left[0]: left = [l, left[0]]
                elif l > left[1]: left[1] = l
            output += right - left[0]
            if left[0] > 0: bonus[left[0]] += left[0] - left[1]
        return output + max(bonus)