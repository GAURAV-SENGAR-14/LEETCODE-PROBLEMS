class Solution {
public:
    vector<string> getLongestSubsequence(vector<string>& s, vector<int>& g) {
        vector<string>ans;
        int n=s.size();
        int curr=g[0];
        ans.push_back(s[0]);

        for(int i=1;i<n;i++){
            if(g[i]!=curr){
                curr^=1;
                ans.push_back(s[i]);
            }
        }
        return ans;
    }
};