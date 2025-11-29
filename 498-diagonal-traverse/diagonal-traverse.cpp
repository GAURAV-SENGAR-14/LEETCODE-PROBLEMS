class Solution {
public:
    vector<int> findDiagonalOrder(vector<vector<int>>& mat) {
        unordered_map<int,vector<int>> mp;
        int n=mat.size(),m=mat[0].size();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mp[i+j].push_back(mat[i][j]);
            }
        }
        vector<int> ans;
        ans.reserve(n*m);
        for(int i=0;i<=n+m-2;i++){
            if(i%2==0){
                reverse(mp[i].begin(),mp[i].end());
            }
            for(auto &num:mp[i]){
                ans.push_back(num);
            }
        }
        return  ans;
    }
};