class Solution {
public:
    void setZeroes(vector<vector<int>>& nums) {
        set<int> r;
        set<int> c;
        int n=nums.size();
        int m=nums[0].size();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(nums[i][j]==0)
                {
                    r.insert(i);
                    c.insert(j);
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(r.count(i)>0 || c.count(j)) nums[i][j]=0;
            }
        } 
    }
};