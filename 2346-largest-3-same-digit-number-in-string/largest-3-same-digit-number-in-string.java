class Solution {
    public String largestGoodInteger(String num) {
        String[] arr={"999","888","777","666","555","444","333","222","111","000"};
        for(int i=0;i<arr.length;i++){
            if(num.contains(arr[i])){
                return arr[i];
            }
        }
        return "";
    }
}