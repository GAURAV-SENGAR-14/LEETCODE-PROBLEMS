class Solution {
    public int largestMagicSquare(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int maxSize = 1;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                for(int k = 2; k + i <= row && k + j <= col; k++){
                    if(k > maxSize && isMagic(grid, i, j, k)){
                        maxSize = Math.max(maxSize, k);
                    }
                }
            }
        }
        return maxSize;
    }

    private boolean isMagic(int[][] grid, int r, int c, int size){
        long sum = 0;

        // reference sum (first column)
        for(int i = r; i < r + size; i++){
            sum += grid[i][c];
        }

        long rSum = 0;

        // check columns
        for(int j = c; j < c + size; j++){
            for(int i = r; i < r + size; i++){
                rSum += grid[i][j];
            }
            if(rSum != sum) return false;
            rSum = 0;
        }

        // check rows
        for(int i = r; i < r + size; i++){
            for(int j = c; j < c + size; j++){
                rSum += grid[i][j];
            }
            if(rSum != sum) return false;
            rSum = 0;
        }

        // main diagonal
        int idx = 0;
        for(int i = r; i < r + size; i++){
            rSum += grid[i][c + idx++];
        }
        if(rSum != sum) return false;

        // anti-diagonal
        rSum = 0;
        idx = 0;
        for(int i = r; i < r + size; i++){
            rSum += grid[i][c + size - 1 - idx++];
        }
        if(rSum != sum) return false;

        return true;
    }
}