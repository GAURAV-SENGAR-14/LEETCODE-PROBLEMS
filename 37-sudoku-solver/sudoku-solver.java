class Solution {

    boolean solve(int i, int j, char[][]board, boolean[][]rows,boolean[][]cols,boolean[][]subMatrix){

        if(i==9)return true;

        if(j==9){
            return solve(i+1,0,board,rows,cols,subMatrix);
        }

        if(board[i][j]!='.') return solve(i,j+1,board,rows,cols,subMatrix);

        for(char ch='1';ch<='9';ch++){
            int idx=(i/3)*3+(j/3);

            if(!rows[i][ch-'0'] && !cols[j][ch-'0'] && !subMatrix[idx][ch-'0']){

                board[i][j]=ch;
                rows[i][ch-'0']=true;
                cols[j][ch-'0']=true;
                subMatrix[idx][ch-'0']=true;

                if(solve(i,j+1,board,rows,cols,subMatrix))
                    return true;

                board[i][j]='.';
                rows[i][ch-'0']=false;
                cols[j][ch-'0']=false;
                subMatrix[idx][ch-'0']=false;

            }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        int n=board.length; 
        boolean[][]rows=new boolean[n+1][n+1];
        boolean[][]cols=new boolean[n+1][n+1];
        boolean[][]subMatrix=new boolean[n][n+1];

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.')continue;
                int num=board[i][j]-'0';
                int idx=(i/3)*3+(j/3);

                rows[i][num]=true;
                cols[j][num]=true;
                subMatrix[idx][num]=true;
            }
        }
        
        solve(0,0,board,rows,cols,subMatrix);
    }
}