class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int length = nums.length;
        int total = Arrays.stream(nums).sum();
        int preSum = 0;
        int[] result = new int[length];

        for(int i = 0; i < length; i++){
            int current = nums[i];
            int currentIndex = i + 1;
            preSum += current;
            
            result[i] = ((currentIndex * current) - preSum) + ((total - preSum) - ((length - currentIndex) * current)); // (left-part till current element) + (right-part)
        }
        return result;
    }
}