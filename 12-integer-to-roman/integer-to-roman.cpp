class Solution {
public:
    string intToRoman(int num) {
        string ans = "";
        vector<int> temp;
        int t = 1;
        while (num > 0) {
            int r = num % 10;
            temp.push_back(r * t);
            t *= 10;
            num /= 10;
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            if (temp[i] >= 900) {
                if (temp[i] > 900) {
                    int x = temp[i] / 1000;
                    while (x--)
                        ans += 'M';
                } else
                    ans += "CM";
            } else if (temp[i] < 900 and temp[i] >= 500) {
                if (temp[i] > 500) {
                    int x = temp[i] - 500;
                    ans += 'D';
                    int t = x / 100;
                    while (t--)
                        ans += 'C';
                } else
                    ans += 'D';
            } else if (temp[i] < 500 and temp[i] >= 100) {
                if (temp[i] == 400)
                    ans += "CD";
                else {
                    int x = temp[i] / 100;
                    while (x--)
                        ans += 'C';
                }
            } else if (temp[i] < 100 and temp[i] >= 50) {
                if (temp[i] == 90)
                    ans += "XC";
                else if (temp[i] < 90 and temp[i] > 50) {
                    int x = temp[i] - 50;
                    ans += 'L';
                    int t = x / 10;
                    cout<<t;
                    while (t--)
                        ans += 'X';
                } else
                    ans += 'L';
            } else if (temp[i] < 50 and temp[i] >= 10) {
                if (temp[i] == 40)
                    ans += "XL";
                else if (temp[i] < 40 and temp[i] > 10) {
                    int x = temp[i] / 10;
                    while (x--)
                        ans += 'X';
                } else
                    ans += 'X';
            } else {
                if (temp[i] == 9)
                    ans += "IX";
                else if (temp[i] == 4)
                    ans += "IV";
                else if (temp[i] == 5)
                    ans += 'V';
                else if (temp[i] < 9 and temp[i] > 5) {
                    int x = temp[i] - 5;
                    ans += 'V';
                    while (x--)
                        ans += 'I';
                } else {
                    int x = temp[i];
                    while (x--)
                        ans += 'I';
                }
            }
        }
        return ans;
    }
};