class Solution {
public:
    string answerString(string word, int numFriends) {
        if (numFriends == 1)
            return word;
        int n = word.size();
        int m = n - numFriends + 1;
        int i = 0, j = 1;
        while (j < n){
            int k = 0;
            while (j + k < n && word[i + k] == word[j + k]){
                k++;
            }
            if (j + k < n && word[i + k] < word[j + k]){
                i = exchange(j, max(j + 1, i + k + 1));
            } else {
                j += k + 1;
            }
        }
        string s = word.substr(i);
        return s.size() <= m ? s : s.substr(0, m);
    }
};