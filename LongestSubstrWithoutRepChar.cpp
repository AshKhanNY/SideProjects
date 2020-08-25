class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if (s.length() < 2) return s.length();
        int max = 0;
        int temp;
        for(int i = 0; i < s.length()-1; ++i){
            temp = 1;
            for(int j = i+1; j < s.length(); ++j){
                bool dupe = false;
                for (int k = i; k < i+temp; ++k){
                    if (s[k] == s[j]){ 
                        dupe = true;
                        break;
                    }
                } 
                if (!dupe) ++temp;
                else break;
            }
            if (temp > max) max = temp;
            if (max >= s.length()-1) break;
        }
        return max;
    }
};