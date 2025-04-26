class Solution {
public:
    long long countSubarrays(vector<int>& nums, int minK, int maxK) {
        int mini=INT_MAX;
        int maxi=INT_MIN;
        long long res=0;
        int i=0,j=0;
        int n=nums.size();
        bool check_mini=false,check_maxi=false;
        while(j<n){
            if(nums[j]>maxK || nums[j]<minK){
                mini=INT_MAX;
                maxi=INT_MIN;
                check_mini=false;
                check_maxi=false;
                i=j+1;}
            if(nums[j]==minK){
                mini=j;
                check_mini=true;
            }
            if(nums[j]==maxK){
                maxi=j;
                check_maxi=true;
            }
            if(check_maxi && check_mini){
            int ind=min(mini,maxi);
            res+=ind-i+1;
            }
            j++;
        }
        return res;
    }
};