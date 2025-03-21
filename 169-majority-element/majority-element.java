class Solution {
    public int majorityElement(int[] nums) {
        int result = 0, count = 0;
        for(int num : nums){
            if(count == 0)
                result = num;
            count += (result == num) ? 1 : -1;
        }

        return result;
    }
}