class Solution {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        Set<Integer> indexToRemove = new HashSet<>();

        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(curr == '(') stack.push(i);
            else if(curr == ')'){
                if(!stack.isEmpty()) stack.pop();
                else indexToRemove.add(i);
            }
        }

        while(!stack.isEmpty()){
            indexToRemove.add(stack.pop());
        }

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            if(!indexToRemove.contains(i))
                result.append(s.charAt(i));
        }

        return result.toString();
    }
}