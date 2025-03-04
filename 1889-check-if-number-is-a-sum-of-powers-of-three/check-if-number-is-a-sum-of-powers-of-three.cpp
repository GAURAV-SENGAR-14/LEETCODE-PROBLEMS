class Solution {
public:
    bool checkPowersOfThree(int n) {
        while(n){
            if((n - (n/3)*3)==2)return false;
            n = n/3;
        }
        return true;
    }
};