class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int balance = target - nums[i];
            if(seen.containsKey(balance))
                return new int[] {seen.get(balance), i};
            seen.put(nums[i], i);
        }

        return null;
    }
}