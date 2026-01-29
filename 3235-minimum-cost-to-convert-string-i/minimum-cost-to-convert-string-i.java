class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long floyd[][]=new long[26][26];
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                floyd[i][j]=Long.MAX_VALUE;
            }
        }
        for(int i=0;i<original.length;i++){
            int s=original[i]-'a';
            int d=changed[i]-'a';
            floyd[s][d]=Math.min(floyd[s][d],cost[i]);
        }
        
        for(int k=0;k<26;k++){
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    if(floyd[i][k]==Long.MAX_VALUE||floyd[k][j]==Long.MAX_VALUE) continue;
                    floyd[i][j]=Math.min(floyd[i][j],floyd[i][k]+floyd[k][j]);
                }
            }
        }
        long ans=0;
        for(int i=0;i<source.length();i++){
            if(source.charAt(i)!=target.charAt(i)){
                int s=source.charAt(i)-'a';
                int d=target.charAt(i)-'a';
                if(floyd[s][d]==Long.MAX_VALUE) return -1;
                ans+=floyd[s][d];
            }
        }
        return ans;
    }
}