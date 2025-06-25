#define ll long long
class Solution {
public:

    ll cntpos(ll m, ll x, vector<int>& nums2) {
        ll s = 0;
        ll e = nums2.size()-1;
        ll ans = -1;
        while(s <= e) {
            ll mid = (s + e) / 2;
            if(x * (ll)nums2[mid] <= m) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return ans == -1 ? 0 : ans + 1;
    }

    ll cntneg(ll m, ll x, vector<int>& nums2) {
        ll s = 0;
        ll e = nums2.size()-1;
        ll ans = -1;
        while(s <= e) {
            ll mid = (s + e) / 2;
            if(x * (ll)nums2[mid] <= m) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans == -1 ? 0 : nums2.size() - ans;
    }

    bool ok(ll m, vector<int>& nums1, vector<int>& nums2, ll k) {
        ll cnt = 0;
        for(int x : nums1) {
            if(x > 0) {
                cnt += cntpos(m, x, nums2);
            } else if(x == 0) {
                if(m >= 0) cnt += nums2.size();
            } else {
                cnt += cntneg(m, x, nums2);
            }
        }
        return cnt >= k;
    }

    long long kthSmallestProduct(vector<int>& nums1, vector<int>& nums2, long long k) {

        ll s = -1e10;
        ll e = 1e10;
        ll ans = 0;
        while(s <= e) {
            ll m = s + (e - s) / 2;
            if(ok(m, nums1, nums2, k)) {
                ans = m;
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return ans;
    }
};