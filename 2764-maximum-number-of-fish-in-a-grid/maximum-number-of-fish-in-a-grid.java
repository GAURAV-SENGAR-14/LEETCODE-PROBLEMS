class Solution {
    int rows;
    int cols;
    public int findMaxFish(int[][] grid) {
        // Store the number of rows and columns in the grid
        rows=grid.length;
        cols=grid[0].length;
        int maxFishes=0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                // If the cell contains fish (grid[i][j] > 0), start a DFS search
                if(grid[i][j]!=0){
                    // Update maxFishes with the maximum number of fish caught from the current cell
                    maxFishes=Math.max(maxFishes,dfs(i,j,grid));
                }
            }
        }
        return maxFishes;
    }

    public int dfs(int r,int c,int grid[][]){
        //if current cell is out of bound
        if(r<0 || r>=rows || c<0 || c>=cols || grid[r][c]==0){
            return 0;
        }
        // Mark the current cell as visited by setting grid[r][c] to 0 (to avoid revisiting it)
        int ans=grid[r][c];
        grid[r][c]=0;

        ans+=dfs(r-1,c,grid) // Move up
             +dfs(r,c+1,grid) // Move right
             +dfs(r+1,c,grid) // Move down
             +dfs(r,c-1,grid); // Move left

            return ans;
    }
}