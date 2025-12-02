class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        

        reslist = []
        sol = []
        n = len(nums)

        def dfs(prevloc):
            reslist.append(sol[:])

            for i in range(prevloc,n):
                if nums[i] not in sol:
                    sol.append(nums[i])
                    dfs(i)
                    sol.pop()
        
        dfs(0)
        return reslist