class Solution(object):
    def partitionArray(self, nums, k):
        nums.sort()
        i = 0
        j = 0
        count = 0
        n = len(nums)

        while j < n:
            if nums[j] - nums[i] > k:
                count += 1
                i = j
            j += 1
        
        return count + 1