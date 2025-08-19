class Solution {
public:
    long long zeroFilledSubarray(vector<int>& nums) {
        int n = nums.size();
        int consec = 0;
        long long ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                consec++;
                ans += consec;
            } else {
                consec = 0;
            }
        }
        return ans;
    }
};