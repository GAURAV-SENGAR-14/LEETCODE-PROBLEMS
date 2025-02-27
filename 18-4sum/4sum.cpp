class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        int n = nums.size()-1;
        if(n<3)
            return {};
        int i{0},j{1},k{2},l{n};
        vector<vector<int>> ans;
        sort(nums.begin(),nums.end());
        for(i=0;i<=n;i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;
            for(j=i+1;j<=n;j++){
                if(j>i+1 && nums[j]==nums[j-1])
                    continue;
                k=j+1;
                l=n;
                while(k<l){
                    long int sum = long(nums[i])+long(nums[j])+long(nums[k])+long(nums[l]);
                    if(sum==target){
                        vector<int> temp{nums[i],nums[j],nums[k],nums[l]};
                        ans.push_back(temp);
                        k++;
                        l--;
                        while(k<l && nums[k]==nums[k-1])
                            k++;
                        while(k<l && nums[l]==nums[l+1])
                            l--;
                    }
                    else if(sum<target)
                        k++;
                    else
                        l--;
                }
            }
        }
    return ans;
    }
};