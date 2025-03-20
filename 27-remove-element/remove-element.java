class Solution {
    public int removeElement(int[] nums, int val) {
        int k = nums.length;
        List<Integer> list = new ArrayList<>();

        for(int num : nums){
            if(num == val) k--;
            else list.add(num);
        }

        for(int i = 0; i < k; i++)
            nums[i] = list.get(i);

        return k;
    }
}