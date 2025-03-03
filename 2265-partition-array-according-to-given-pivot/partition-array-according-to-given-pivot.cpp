class Solution {
public:
    vector<int> pivotArray(vector<int>& nums, int pivot) {
        stable_partition(begin(nums), end(nums), [&](int x) { return x <= pivot; });
        stable_partition(begin(nums), end(nums), [&](int x) { return x < pivot; });
        return nums;
    }
};