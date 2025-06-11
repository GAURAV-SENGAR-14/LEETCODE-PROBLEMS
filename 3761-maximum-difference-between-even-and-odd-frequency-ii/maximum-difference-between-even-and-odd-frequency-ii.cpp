class Solution {
public:
    int maxDifference(string s, int k) {
        int n = s.size();
        int ans = INT_MIN; 

        for(int a = 0; a <= 4; a++) {
            for(int b = 0; b <= 4; b++) {
                if(a == b) continue; 
                int cnta = 0;
                int cntb = 0; 
                for(int i = 0; i < k; i++) {
                    cnta += ((s[i]-'0') == a);
                    cntb += ((s[i]-'0') == b); 
                }
                if(cnta && cntb) {
                    if(cnta%2 && cntb%2 == 0) {
                        ans = max(ans, cnta-cntb); 
                    }
                }
                
                // if(a == 1) {
                //     cout<<b<<" "<<ans<<endl;
                // }
                int cntaj = 0, cntbj = 0; 
                int tempoo = INT_MIN, tempee = INT_MIN, tempeo = INT_MIN, tempoe = INT_MIN; 
                int j = 0; 
                for(int i = k; i < n; i++) {
                    cnta += ((s[i]-'0') == a);
                    cntb += ((s[i]-'0') == b); 

                    if(cnta == 0 || cntb == 0) continue;

                    while(j <= i-k) {
                        cntaj += ((s[j]-'0') == a);
                        cntbj += ((s[j]-'0') == b); 

                        if(cntaj == cnta || cntbj == cntb) {
                            cntaj -= ((s[j]-'0') == a);
                            cntbj -= ((s[j]-'0') == b); 
                            break;  
                        } else {
                            if(cntaj%2 == 0 && cntbj%2 == 0) {
                                tempee = max(tempee, cntbj-cntaj);
                            } else if(cntaj%2 && cntbj%2) {
                                tempoo = max(tempoo, cntbj-cntaj);
                            } else if(cntaj%2 == 0 && cntbj%2) {
                                tempeo = max(tempeo, cntbj-cntaj);
                            }  else {
                                tempoe = max(tempoe, cntbj-cntaj);
                            }
                            j++; 
                        }
                    }
                    

                    
                    
                    if(cnta%2 == 0 && cntb%2 == 0) {
                        if(tempoe != INT_MIN) {
                            ans = max(ans, cnta-cntb+tempoe);
                        }
                    } else if(cnta%2 && cntb%2) {
                        if(tempeo != INT_MIN) {
                            ans = max(ans, cnta-cntb+tempeo);
                        }
                    } else if(cnta%2 == 0 && cntb%2) {
                        if(tempoo != INT_MIN) {
                            ans = max(ans, cnta-cntb+tempoo);
                        }
                    } else {
                        ans = max(ans, cnta-cntb); 
                        if(tempee != INT_MIN) {
                            ans = max(ans, cnta-cntb+tempee);
                        } 
                    }
                }
                
            }
        }
        return ans;
    }
};