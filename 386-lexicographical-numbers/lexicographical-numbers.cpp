class Solution {
public:
    int N;
    void solve(vector<int>& ans, int val){
        for(int i = 0;i<=9;i++){
            if(val + i <= N){
                if(val + i == 0) continue;
                ans.push_back(val + i);
                solve(ans, (val+i)*10);
            }
            else return ;
        }
        return ;
    }
    vector<int> lexicalOrder(int n) {
        vector<int> arr;
        N = n;
        solve(arr, 0);
        return arr;
    }
};