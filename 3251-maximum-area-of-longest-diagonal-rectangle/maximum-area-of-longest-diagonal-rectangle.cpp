class Solution {
public:
    int areaOfMaxDiagonal(vector<vector<int>>& dimensions) {
        double max_dia = 0.0;
        int max_area = 0 ;
        for(const auto &dim : dimensions){
            int length = dim[0];
            int breadth = dim[1];
            double dia = sqrt(pow(length,2) + pow(breadth,2));
            if(dia > max_dia){
                 max_dia = dia;
                max_area = length*breadth;
            }else if(dia == max_dia){
                max_area = max(max_area,length*breadth);
            }
        }
        return max_area;
    }
};