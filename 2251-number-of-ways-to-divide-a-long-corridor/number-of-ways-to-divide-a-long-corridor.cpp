class Solution {
public:
    int numberOfWays(string corridor) {
        int mod = 1000000007;
        int n = corridor.size();
        int cnt = 0;
        for(char c : corridor){
            if(c == 'S') cnt++;
        }
        if(cnt == 0 || cnt % 2 != 0) return 0;
        cnt = 0;
        long long ans = 1;
        int i = 0, p = 0; bool flag = false;
        while(i < n){
            if(corridor[i] == 'S'){
                cnt++;
                if(cnt % 2 == 0){
                    flag = true;
                } else if(cnt > 2){
                    ans = (ans * (p + 1)) % mod;
                    cnt = 1; flag = false; p = 0;
                }
            } else if(flag){
                p++;
            }
            i++;
        }
        return (int)ans;
    }
};