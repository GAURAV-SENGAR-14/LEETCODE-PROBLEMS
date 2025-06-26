class Solution {
    public int longestSubsequence(String s, int k) {
        int sum=0;
        int ans=-1;
        int res=-1;
        int n=s.length();
        if(n==1)
        {
            return 1;
        }
        for(int i=s.length()-1;i>=0;i--)
        {
           int bit=s.charAt(i)-'0';
           sum+=bit*Math.pow(2,n-i-1);
           if(sum>k)
           {
             ans=n-i-1;
             res=i;
             break;
           }
        }
        int c=0;
        if(ans==-1 && res==-1)
        {
            return n;
        }
        for(int i=res-1;i>=0;i--)
        {
            if(s.charAt(i)=='0')
            {
                c++;
            }
        }
        System.out.println(c);
       return ans+c;
    }
}