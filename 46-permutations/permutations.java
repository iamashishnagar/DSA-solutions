class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, visited, new ArrayList(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] visited, List<Integer> permutation, List<List<Integer>> result){
        if(permutation.size() == nums.length){
            result.add(new ArrayList<>(permutation));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(visited[i]) continue;
            permutation.add(nums[i]);
            visited[i] = true;

            backtrack(nums, visited, permutation, result);
            permutation.remove(permutation.size() - 1);
            visited[i] = false;
        }
    }
}