class Solution
{
private:
    using matrix=long long [26][26];
    const int MOD=1e9+7;
    matrix trans_t;
    
    void multiply(matrix& x,matrix& y)
    {
        int i,j,k;
        long long ret[26][26];
        memset(ret,0,sizeof(ret));
        for(i=0;i<26;i++)
        {
            for(k=0;k<26;k++)
            {
                for(j=0;j<26;j++)
                {
                    ret[i][j]=(ret[i][j]+x[i][k]*y[k][j])%MOD;
                }
            }
        }
        memcpy(x,ret,sizeof(ret));
    }

    void power(matrix& base,int pow)
    {
        int i;
        memset(trans_t,0,sizeof(trans_t));
        for(i=0;i<26;i++)
        {
            trans_t[i][i]=1;
        }
        while(pow)
        {
            if(pow&1)
            {
                multiply(trans_t,base);
            }
            multiply(base,base);
            pow>>=1;
        }
    }
    
public:
    int lengthAfterTransformations(string s, int t, vector<int>& nums)
    {
        long long list[26]={0};
        for(char c:s)
        {
            list[c-'a']++;
        }
        matrix trans;
        memset(trans,0,sizeof(trans));
        for(int i=0;i<26;i++)
        {
            for(int j=1;j<=nums[i];j++)
            {
                trans[i][(i+j)%26]++;
            }
        }
        for(int i=0;i<26;i++)
        {
            for(int j=0;j<26;j++)
            {
                trans[i][j]%=MOD;
            }
        }
        power(trans,t);
        long long sum=0;
        for(int i=0;i<26;i++)
        {
            for(int j=0;j<26;j++)
            {
                sum+=trans_t[i][j]*list[i];
            }
            sum%=MOD;
        }
        return sum%MOD;
    }
};