class Solution {
public:
    int maxDistance(string s, int k) {
        int n = s.length();
        int N=0, S=0, E=0, W=0;
        int res=0;
        for (int i=0; i<n; i++){
            char c = s[i];
            switch(c){
                case 'N':N++; break;
                case 'S':S++; break;
                case 'E':E++; break;
                case 'W':W++; break;
            }
            int dist = abs(N-S)+abs(E-W)+2*k;
            res = max(res, min(dist, i+1));
        }
        return res;
    }
};