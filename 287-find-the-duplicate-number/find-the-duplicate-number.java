class Solution {
    public int findDuplicate(int[] nums) {
        //detect the cycle
        int slow = nums[0];
        int fast = nums[0];

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        //find the entry point of the cycle
        slow = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}