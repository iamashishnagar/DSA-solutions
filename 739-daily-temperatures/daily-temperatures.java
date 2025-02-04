class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        if(n == 0) return null;
        int[] result = new int[n];
        Deque<Integer> indexStack = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            while(!indexStack.isEmpty() && temperatures[indexStack.peek()] < temperatures[i]){
                int index = indexStack.pop();
                result[index] = i - index;
            }
            indexStack.push(i);
        }
        return result;
    }
}