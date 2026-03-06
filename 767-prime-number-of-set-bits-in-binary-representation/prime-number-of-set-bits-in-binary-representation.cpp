class Solution {
public:

    bool isPrime(int n){
        if(n < 2) return false;
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    string decimaltobinary(int n){

        string s="";

        while(n > 0){
            s+=to_string(n%2);
            n=n/2;
        }

        return s;
    }



    int countPrimeSetBits(int left, int right) {
        
        int count=0;

        for(int i=left;i<=right;i++){
            string s=decimaltobinary(i);

            int one=0;
            for(int j=0;j<s.size();j++){
                if(s[j]=='1'){
                    one++;
                }
            }
            if(isPrime(one)){
                count++;
            }
        }
        return count;
    }
};