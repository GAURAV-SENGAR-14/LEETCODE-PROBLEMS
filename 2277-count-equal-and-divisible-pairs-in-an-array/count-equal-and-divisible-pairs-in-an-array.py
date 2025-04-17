class Solution:
    def countPairs(self, nums: List[int], k: int) -> int:
        return len([1 for x in range(len(nums)) for y in range(x+1 , len(nums)) if nums[x] == nums[y] and (x * y) % k == 0])