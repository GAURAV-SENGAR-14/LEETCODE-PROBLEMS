class Solution
{
public:
    long long dp[11] = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1};
    unordered_set<string>vis;
    long long fact(int n)
    {
        if (n == 0 || n == 1)
            return 1;
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = n * fact(n - 1);
    }
    int solve(string temp, int ind, int x, int k, int n)
    {
        if (ind == x)
        {
            long long j = stoll(temp);
            if (j % k == 0)
            {
                sort(temp.begin(),temp.end());
                if(vis.find(temp)!=vis.end())return 0;
                vis.insert(temp);
                unordered_map<char, int> mp;
                for (auto it : temp)
                {
                    mp[it]++;
                }
                long long deno = 1;

                for (auto it : mp)
                {
                    long long gg = fact(it.second);
                    deno *= gg;
                }
                long long num = fact(n);
                long long pp = num / deno;
                if (mp['0'])
                {
                    int x = mp['0'] - 1;
                    long long hh = 1;
                    for (auto it : mp)
                    {
                        if (it.first != '0')
                        {
                            hh *= (fact(it.second));
                        }
                    }
                    hh *= (fact(x));
                    long long mm = fact(n - 1);
                    mm /= hh;
                    return pp - mm;
                }
                return pp;
            }

            else
                return 0;
        }
        long long ans = 0;
        for (int i = 0; i <= 9; i++)
        {
            if (ind == 0 && i == 0)
                continue;

            char orr = temp[ind];
            temp[ind] = (i + '0');
            temp[n - ind - 1] = (i + '0');
            ans += solve(temp, ind + 1, x, k, n);
            temp[ind] = orr;
            temp[n - ind - 1] = orr;
        }
        return ans;
    }
    long long countGoodIntegers(int n, int k)
    {
        string temp = "";
        for (int i = 0; i < n; i++)
        {
            temp += "0";
        }
        int x = (n + 1) / 2;
        return solve(temp, 0, x, k, n);
    }
};