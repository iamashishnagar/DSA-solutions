class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int index, int[] candidates, int target, List<Integer> combination, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(combination));
            return;
        }

        for(int i = index; i < candidates.length; i++){
            if(i > index && candidates[i] == candidates[i - 1]) continue;
            if(candidates[i] > target) break;

            combination.add(candidates[i]);
            backtrack(i + 1, candidates, target - candidates[i], combination, result);
            combination.remove(combination.size() - 1);
        }
    }
}