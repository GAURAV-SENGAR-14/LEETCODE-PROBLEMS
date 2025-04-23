class Solution {
    public int countLargestGroup(int n) {
        int nums[]=new int[37];
        int max=Integer.MIN_VALUE,count=0;
        for(int i=1;i<=n;i++){
            int dig=digsum(i);
            nums[dig]++;
            if(nums[dig]>max){
                max=nums[dig];
                count=1;
            }
            else if (nums[dig]==max)count++;
        }
        return count;
    }
    int digsum(int n){
        int sum=0;
        while(n>0){
            sum+=(n%10);
            n/=10;
        }
        return sum;
    }
}