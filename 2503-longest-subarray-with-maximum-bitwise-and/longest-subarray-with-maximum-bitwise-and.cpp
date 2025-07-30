class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        int maxElement = *max_element(nums.begin(), nums.end());
        
        int longest = 0, current = 0;

        for (int &x : nums)
        {
            if (x == maxElement)
            {
                current++;
                longest = max(longest, current);
            }
            else 
            {
                current = 0;
            }
        }
        return longest;
    }
};