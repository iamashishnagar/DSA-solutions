class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList(), result);
        return result;
    }

    private void backtrack(int index, int[] candidates, int target, List<Integer> combination, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList(combination));
            return;
        }
        if(target < 0) return;

        for(int i = index; i < candidates.length; i++){
            combination.add(candidates[i]);
            backtrack(i, candidates, target - candidates[i], combination, result);
            combination.remove(combination.size() - 1);
        }
    }
}