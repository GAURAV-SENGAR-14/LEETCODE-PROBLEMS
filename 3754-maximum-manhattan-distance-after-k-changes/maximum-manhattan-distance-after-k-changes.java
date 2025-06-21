class Solution {
    public int maxDistance(String s, int k) {
        int ans=0;
        int n=s.length();
        for(char hor:new char[]{'E','W'}){
            for(char ver:new char[]{'N','S'}){
                int remK=k;
                int netX=0, netY=0;
                for(int i=0;i<n;i++){
char ch=s.charAt(i);
// 1. flip horizontal
if(ch==hor && remK>0){
    ch=(ch=='W')?'E':'W';  
    remK--;
}
// 2. flip vertical 
if(ch==ver && remK>0){
    ch=(ch=='N')?'S':'N';
    remK--;
}

if(ch=='E')netX++;
if(ch=='W')netX--;
if(ch=='N')netY++;
if(ch=='S')netY--;

ans=Math.max(ans, Math.abs(netX)+Math.abs(netY));
                }
            }
        }
        return ans;
    }
}