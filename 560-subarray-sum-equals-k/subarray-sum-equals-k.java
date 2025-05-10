class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int num : nums){
            sum += num;
            int diff = sum - k;
            result += map.getOrDefault(diff, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}