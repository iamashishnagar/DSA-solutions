class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        for(int num : nums){
            currentSum += num;
            int requiredPrevSum = currentSum - k;
            count += preSum.getOrDefault(requiredPrevSum, 0);
            preSum.put(currentSum, preSum.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}