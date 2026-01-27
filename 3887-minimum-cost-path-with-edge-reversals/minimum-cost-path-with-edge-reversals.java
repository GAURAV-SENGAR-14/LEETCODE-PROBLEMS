class Solution {
    public int minCost(int n, int[][] edges) {
        ArrayList<int[]>[] adj = new ArrayList[n];
        for(int i = 0;i < n;i++) adj[i] = new ArrayList<>();

        for(int[] edge: edges) {
            adj[edge[0]].add(new int[]{edge[1], edge[2]});
            adj[edge[1]].add(new int[]{edge[0], 2*edge[2]});
        }

        int[] rch = new int[n];
        Arrays.fill(rch, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{0, 0});
        rch[0] = 0;

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int nd = cur[0];
            int curWg = cur[1];
            
            if(curWg > rch[nd]) continue;
            for(int[] nxt: adj[nd]) {
                int tmpWe = nxt[1]+curWg;
                if(rch[nxt[0]] > tmpWe){
                    rch[nxt[0]] = tmpWe;
                    pq.offer(new int[]{nxt[0], tmpWe});
                }
            }
        }
        
        return rch[n-1] == Integer.MAX_VALUE ? -1: rch[n-1];
    }
}