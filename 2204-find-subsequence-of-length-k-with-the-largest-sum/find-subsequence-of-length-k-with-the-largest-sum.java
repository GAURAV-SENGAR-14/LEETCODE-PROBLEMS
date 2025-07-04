class pair{
        int p;
        int q;
        pair(int p,int q){
            this.p=p;
            this.q=q;
        }
    }
    class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        Queue<pair> pq1 = new PriorityQueue<>((a,b) -> b.p-a.p);
        for(int i=0;i<nums.length;i++) pq1.offer(new pair(nums[i],i));
        Queue<pair> pq2 = new PriorityQueue<>((a,b) -> a.q-b.q);
        for(int i=0;i<k;i++){
            pq2.offer(pq1.poll());
        }
        int[] ans = new int[k];
        int i=0;
        while(!pq2.isEmpty()){
            ans[i++] = pq2.peek().p;
            pq2.poll();
        }

        return ans;
    }
}