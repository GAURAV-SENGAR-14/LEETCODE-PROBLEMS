class Solution {
public:
    int countSegments(string s) {
      int c = 0; string temp = ""; 
      for(int i=0; i<s.length(); i++){
          if(s[i] == ' ' && temp != "") {c++; temp = ""; }
          else if(s[i] == ' ') continue; 
          else temp += s[i]; 
      }
      if(temp != "") c++; 
      return c;
    }
};