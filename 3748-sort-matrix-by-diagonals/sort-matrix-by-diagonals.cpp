class Solution {
public:
    int n;
    void sortdiagonal(int r,int c,vector<vector<int>>& grid,bool type){
        vector<int> vec;
        int i = r,j=c;
        while(i<n && j<n){
            vec.push_back(grid[i][j]);
            i++;
            j++;
        }
        if(type){
            sort(begin(vec),end(vec));
        }else{
            sort(rbegin(vec),rend(vec));
        }
        i = r,j=c;
        for(int &val : vec){
            grid[i][j] = val;
            i++;
            j++;
        }
    }
    vector<vector<int>> sortMatrix(vector<vector<int>>& grid) {
        n = grid.size();
        for(int row = 0;row<n;row++){
            sortdiagonal(row,0,grid,false);
        }
        for(int col = 1;col<n;col++){
            sortdiagonal(0,col,grid,true);
        }
        return grid;
    }
};