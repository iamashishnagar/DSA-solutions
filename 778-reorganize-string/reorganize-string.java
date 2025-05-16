class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }

        int maxFreq = Arrays.stream(freq).max().getAsInt();
        if(maxFreq > (s.length() + 1) / 2) return "";

        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int i = 0; i < freq.length; i++){
            if(freq[i] > 0) maxHeap.offer(new int[] {freq[i], i});
        }

        StringBuilder result = new StringBuilder();

        while(maxHeap.size() >= 2){
            int[] first = maxHeap.poll();
            int[] second = maxHeap.poll();
            result.append((char) (first[1] + 'a'));
            result.append((char) (second[1] + 'a'));
            if(--first[0] > 0) maxHeap.offer(first);
            if(--second[0] > 0) maxHeap.offer(second);
        }

        if(!maxHeap.isEmpty())
            result.append((char) (maxHeap.poll()[1] + 'a'));
        
        return result.toString();
    }
}