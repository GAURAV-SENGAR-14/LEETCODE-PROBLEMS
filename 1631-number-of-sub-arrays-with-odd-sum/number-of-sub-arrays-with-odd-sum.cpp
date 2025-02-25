class Solution {
public:
    int numOfSubarrays(vector<int>& arr) {
    
        
        int odd=0;
        int even=0;
        long int currSum=0;
        long int res=0;
        for(int i=0;i<arr.size();i++)
        {
            currSum+=arr[i];
            if(currSum&1)
            {
                //odd sum 
                res+=1;
                //get the number of previous even sub array sums
                res+=even;
                odd++;
            }
            else{
                
                res+=odd;
                
                even++;
            }
        }
        return (long)res%1000000007;
    }
};