class Solution {
public:
    void set(vector<vector<int>>& tree,vector<int> &res,int vertex,int parent,int &odd,int &even,int k){
        if(k%2==0){
            res[vertex]+=even;
        }
        else res[vertex]+=odd;
        for (int it : tree[vertex]) {
            if (it != parent) {
                set(tree,res,it,vertex,odd,even,k+1);
            }
        }
    }
    void get_neighbours(vector<vector<int>>& tree, int vertex, int parent,
                       int k,int &odd,int &even) {
        if (k %2 == 0) even++;
        else odd++;
        for (int it : tree[vertex]) {
            if (it != parent) {
                get_neighbours(tree, it, vertex, k + 1,odd,even);
            }
        }
        
    }
    vector<int> maxTargetNodes(vector<vector<int>>& edges1, vector<vector<int>>& edges2) {
        int n = edges1.size();
        int m = edges2.size();
        vector<vector<int>> tree1(n + 1);
        vector<vector<int>> tree2(m + 1);
        for (int i = 0; i < n; i++) {
            tree1[edges1[i][0]].push_back(edges1[i][1]);
            tree1[edges1[i][1]].push_back(edges1[i][0]);
        }
        for (int i = 0; i < m; i++) {
            tree2[edges2[i][0]].push_back(edges2[i][1]);
            tree2[edges2[i][1]].push_back(edges2[i][0]);
        }
        int odd=0,even=0;
        for (int i = 0; i < m+1; i++) {
           if(tree2[i].size()==1){
               get_neighbours(tree2, i, m + 10,0,odd,even);
               break;
           }
        }
        vector<int> res(n + 1, max(odd,even));
        odd=0;
        even=0;
        for (int i = 0; i < n+1; i++) {
           if(tree1[i].size()==1){
               get_neighbours(tree1, i, n + 10,0,odd,even);
               set(tree1,res,i,n+10,odd,even,0);
               break;
           }
        }
        return res;
    }
};