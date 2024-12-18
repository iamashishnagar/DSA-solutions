class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        int longest = 0;

        for(int num : nums){
            set.add(num);
        }

        for(int num : set){
            int currentNum = num;
            int currentStreak = 1;
            if(!set.contains(currentNum - 1)){

                while(set.contains(currentNum + 1)){
                    currentNum++;
                    currentStreak++;
                }
            }
            longest = Math.max(longest, currentStreak);
        }
        
        return longest;
    }
}