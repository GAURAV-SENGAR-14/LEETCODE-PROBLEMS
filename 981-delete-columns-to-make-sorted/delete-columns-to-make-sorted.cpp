class Solution {
public:
    int minDeletionSize(vector<string>& strs) {
        int cnt = 0;
        int col = strs[0].size();
        int row = strs.size();
        for (int i = 0; i < col; i++){
            for (int j = 1; j < row; j++){
                if (strs[j][i] < strs[j - 1][i]){
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }
};