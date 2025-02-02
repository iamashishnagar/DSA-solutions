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
                int length = 1;
                while(set.contains(curr + 1)){
                    length++;
                    curr = curr + 1;
                }
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}