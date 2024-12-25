class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Deque<Integer> indexStack = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            while(!indexStack.isEmpty() && temperatures[i] > temperatures[indexStack.peek()]){
                result[indexStack.peek()] = i - indexStack.pop();
            }
            indexStack.push(i);
        }

        return result;        
    }
}