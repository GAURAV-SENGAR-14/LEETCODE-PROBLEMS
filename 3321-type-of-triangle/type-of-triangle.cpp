class Solution {
public:
    string triangleType(vector<int>& nums) {
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];

        if(a+b > c && b+c > a && c+a > b) {
            if(a == b && b == c && c == a) return "equilateral";
            else if (a == b || b == c || a == c) return "isosceles";
            else if(a != b != c) return "scalene";
        }
        return "none";
    }
};