class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);

        int longest = 0;
        for(int num : set){
            if(set.contains(num - 1)) continue;
            int curr = num;
            int streak = 1;
            while(set.contains(curr + 1)){
                streak++;
                curr++;
            }
            longest = Math.max(longest, streak);
        }
        return longest;
    }
}