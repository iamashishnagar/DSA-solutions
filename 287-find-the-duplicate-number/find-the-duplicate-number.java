class Solution {
    public int findDuplicate(int[] nums) {
        //find cycle
        int slow = nums[0], fast = nums[0];

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while(slow != fast);

        //find entry to cycle
        slow = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}