#define MOD 1000000007
#define MAX 100005

long long fact[MAX], invFact[MAX];

long long power(long long x, long long y) {
    long long res = 1;
    x %= MOD;
    while (y) {
        if (y & 1) res = res * x % MOD;
        x = x * x % MOD;
        y >>= 1;
    }
    return res;
}

void precomputeFactorials(int max) {
    fact[0] = invFact[0] = 1;
    for (int i = 1; i <= max; i++) {
        fact[i] = fact[i - 1] * i % MOD;
        invFact[i] = power(fact[i], MOD - 2);
    }
}

long long comb(int n, int k) {
    if (k < 0 || k > n) return 0;
    return fact[n] * invFact[k] % MOD * invFact[n - k] % MOD;
}

int countGoodArrays(int n, int m, int k) {
    precomputeFactorials(n);  // max value needed is up to n - 1
    long long c = comb(n - 1, k);
    long long res = c * m % MOD * power(m - 1, n - k - 1) % MOD;
    return (int)res;
}