class Solution {
    private int n;
    
    public int snakesAndLadders(int[][] board) {
        n = board.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[] visited = new boolean[n * n + 1];
        pq.offer(new int[]{0, 1});
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int moves = current[0];
            int square = current[1];
            
            for (int i = 1; i <= 6; i++) {
                int nextSquare = square + i;
                if (nextSquare > n * n) continue;
                
                int[] pos = numToPos(nextSquare);
                if (board[pos[0]][pos[1]] != -1) {
                    nextSquare = board[pos[0]][pos[1]];
                }
                
                if (nextSquare == n * n) return moves + 1;
                
                if (!visited[nextSquare]) {
                    visited[nextSquare] = true;
                    pq.offer(new int[]{moves + 1, nextSquare});
                }
            }
        }
        return -1;
    }
    
    private int[] numToPos(int num) {
        int row = (num - 1) / n;
        int col = (num - 1) % n;
        if (row % 2 == 1) {
            col = n - 1 - col;
        }
        row = n - 1 - row;
        return new int[]{row, col};
    }
}