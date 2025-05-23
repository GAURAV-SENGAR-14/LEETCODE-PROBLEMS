class Solution {
public:
    typedef long long ll;
    long long maximumValueSum(vector<int>& nums, int k, vector<vector<int>>& edges) {
        ll sum=0;
        int count=0;
        int minLoss=INT_MAX;
        for(ll i:nums){
            if((i^k)>i){
                count++;
                sum+=i^k;
            }
            else sum+=i;

            minLoss=min((ll)minLoss,abs(i-(i^k)));
        }
        if(count%2==0) return sum;
        return sum-minLoss;
    }
};