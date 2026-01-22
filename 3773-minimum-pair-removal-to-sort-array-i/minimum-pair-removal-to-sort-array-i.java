class Solution {
    public boolean check(List<Integer> arr){
        if(arr.size() == 1) return true; // single element is sorted

        for(int i = 1; i < arr.size(); i++){
            if(arr.get(i - 1) > arr.get(i)) return false; // not sorted
        }
        return true;
    }

    public int minimumPairRemoval(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for(int n : nums){
            arr.add(n); // convert array to list
        }

        if(check(arr)) return 0; // already sorted

        int count = 0;

        while(true){
            int sum = Integer.MAX_VALUE;
            int ind = -1;

            // find adjacent pair with minimum sum
            for(int i = 1; i < arr.size(); i++){
                int temp = arr.get(i - 1) + arr.get(i);
                if(temp < sum){
                    sum = temp;
                    ind = i - 1;
                }
            }

            // remove the pair
            arr.remove(ind + 1);
            arr.remove(ind);

            // insert their sum
            arr.add(ind, sum);
            count++;

            if(check(arr)) break; // stop when sorted
        }
        return count;
    }
}