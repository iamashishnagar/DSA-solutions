class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        Queue<Pair<String, Integer>> queue = new ArrayDeque<>();
        queue.offer(new Pair<>(beginWord, 1));

        while(!queue.isEmpty()){
            Pair<String, Integer> pair = queue.poll();
            String word = pair.getKey();
            int steps = pair.getValue();

            if(word.equals(endWord)) return steps;
            char[] letters = word.toCharArray();
            for(int i = 0; i < letters.length; i++){
                char original = letters[i];
                for(char c = 'a'; c <= 'z'; c++){
                    if(c == original) continue;

                    letters[i] = c;
                    String newWord = new String(letters);
                    if(set.contains(newWord)){
                        queue.offer(new Pair<>(newWord, steps + 1));
                        set.remove(newWord);
                    }
                }
                letters[i] = original;
            }
        }

        return 0;
    }
}