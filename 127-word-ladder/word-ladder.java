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

            char[] wordArray = word.toCharArray();
            for(int i = 0; i < wordArray.length; i++){
                char original = wordArray[i];

                for(char c = 'a'; c <= 'z'; c++){
                    if(c == original) continue;

                    wordArray[i] = c;
                    String newWord = new String(wordArray);

                    if(set.contains(newWord)){
                        queue.offer(new Pair<>(newWord, steps + 1));
                        set.remove(newWord);
                    }
                }
                wordArray[i] = original;
            }
        }

        return 0;
    }
}