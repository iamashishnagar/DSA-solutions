class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0)
            return new ArrayList();

        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] word = s.toCharArray();
            Arrays.sort(word);
            String key = new String(word);

            map.putIfAbsent(key, new ArrayList());
            map.get(key).add(s);
        }

        return new ArrayList(map.values());
     
    }
}