class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for(int num : nums)
            set.add(num);
        
        int longest = 0;

        for(int num : set){ //set - not num
            if(set.contains(num - 1)) continue;
            int curr = num;
            int streak = 1;
            while(set.contains(curr + 1)){
                streak++;
                curr += 1;
            }
            longest = Math.max(longest, streak);
        }
        return longest;
    }
}