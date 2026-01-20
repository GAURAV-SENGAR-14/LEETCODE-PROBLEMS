class Solution {
public:
    bool tool(vector<vector<int>>& prefix_sum,int side_length,int limit)
    {
        int n=prefix_sum.size();
        int m=prefix_sum[0].size();

        for(int i=side_length-1;i<n;i++)
        {
            for(int j=side_length-1;j<m;j++)
            {
                int x1=i-side_length+1;
                int y1=j-side_length+1;

                int summation=prefix_sum[i][j]
                        -(x1>0?prefix_sum[x1-1][j]:0)
                        -(y1>0?prefix_sum[i][y1-1]:0)
                        +(x1>0 && y1>0 ? prefix_sum[x1-1][y1-1]:0);
                
                if(summation<=limit) 
                    return true;
            }
        }
        return false;
    }
    int maxSideLength(vector<vector<int>>& mat, int threshold) {
        int n=mat.size();
        int m=mat[0].size();
        
        vector<vector<int>> prefix_sum=mat;
        for(int i=0;i<n;i++)
            for(int j=1;j<m;j++)
                prefix_sum[i][j]+=prefix_sum[i][j-1];

        for(int j=0;j<m;j++)
            for(int i=1;i<n;i++)
                prefix_sum[i][j]+=prefix_sum[i-1][j];

        int low=1;
        int high=min(m,n);
        int ans=0;
        while(low<=high)
        {
            int mid=(high+low)/2;
            if(tool(prefix_sum,mid,threshold))
            {
                ans=mid;
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return ans;
    }
};