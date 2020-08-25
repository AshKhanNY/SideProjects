class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        map<int, int> temp;
        double median = 0;
        double half = (nums1.size() + nums2.size())/2.0;
        for (auto& elem : nums1){
            auto result = temp.insert(pair<int, int>(elem, 1));
            if (result.second == false)
                result.first->second++;
        }
        for (auto& elem : nums2){
            auto result = temp.insert(pair<int, int>(elem, 1));
            if (result.second == false)
                result.first->second++;
        }
        
        double count = 0;
        int i;
        map<int, int>::iterator it;
        for (it = temp.begin(); it != temp.end(); it++){
            i = 0;
            while (i < it->second){
                if (floor(half) == half){
                    if (count + 1 == half){
                        median = it->first;
                        if (i+1 == it->second){   
                            ++it;
                            median = (median + it->first)/2;
                        }
                        return median;
                    }
                } else { 
                    if (count + 1 > half){
                        median = it->first;
                        return median;
                    }
                }
                ++count;
                ++i;
            }
        }
        return median;
    }
};