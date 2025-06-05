class Solution {
public:
    
    string smallestEquivalentString(string s1, string s2, string bb) {
        vector<vector<int>>adj(26);

        int n=s1.size();
        for(int i=0;i<n;i++){
            if(s1[i]!=s2[i]){
                adj[s1[i]-'a'].push_back(s2[i]-'a');
                adj[s2[i]-'a'].push_back(s1[i]-'a');
            }
        }
        vector<int>vis(26,0);
        int y=0;
        for(int i=0;i<26;i++){
            if(!vis[i]){
                y++;
                vis[i]=y;
                queue<int>q;
                q.push(i);
                while(!q.empty()){
                    int a=q.front();
                    q.pop();
                    for(int j=0;j<adj[a].size();j++){
                        if(!vis[adj[a][j]]){
                            vis[adj[a][j]]=y;
                            q.push(adj[a][j]);
                        }
                    }
                }
            }
        }
        vector<char>yy(y,0);
        for(int i=0;i<26;i++){
            if(!yy[vis[i]-1]){
                yy[vis[i]-1]=char(i+'a');
            }
        }
        string st="";
        for(int i=0;i<bb.size();i++){
            st=st+yy[vis[bb[i]-'a']-1];
        }
        return st;
    }
};