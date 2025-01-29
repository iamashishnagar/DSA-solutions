class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, result, new ArrayList<>());
        return result;
    }

    private void backtrack(int index, int[] nums, List<List<Integer>> result, List<Integer> current){
        result.add(new ArrayList<>(current));
        if(index >= nums.length) return;

        for(int i = index; i < nums.length; i++){
            current.add(nums[i]);
            backtrack(i + 1, nums, result, current);
            current.remove(current.size() - 1);
        }
    }
}