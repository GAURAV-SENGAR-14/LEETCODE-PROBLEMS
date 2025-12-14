class Solution {
    public int numberOfWays(String corridor) {
        long seat=0,plant=0,totalSeat=0,ans=1;
        for(int i=0;i<corridor.length();i++) {
            char c = corridor.charAt(i);
            if(c=='S') {
                seat++;
                totalSeat++;
                if(seat==3) {
                    ans = ans*(plant+1)%1000000007;
                    seat=1;
                    plant=0;
                }
            } else if(c=='P') {
                if(seat==2)
                    plant++;
            }
        }
        if(totalSeat%2==1 || totalSeat==0) return 0;
        return (int)ans;
    }
}