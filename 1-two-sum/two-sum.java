class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            int balance = target - nums[i];
            if(map.containsKey(balance) && map.get(balance) != i)
                return new int[] {i, map.get(balance)};
        }

        return new int[] {-1, -1};
    }
}