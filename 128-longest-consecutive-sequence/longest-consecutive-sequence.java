class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int longest = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums)
            set.add(num);
        
        for(int num : set){
            if(!set.contains(num - 1)){
                int curr = num;
                int streak = 1;
                while(set.contains(curr + 1)){
                    streak++;
                    curr++;
                }
                longest = Math.max(longest, streak);
            }
        }
        return longest;
    }
}