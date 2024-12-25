class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> indexStack = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!indexStack.isEmpty() && temperatures[i] > temperatures[indexStack.peek()]){
                result[indexStack.peek()] = i - indexStack.pop();
            }
            indexStack.push(i);
        }

        return result;        
    }
}