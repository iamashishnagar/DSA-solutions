class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> group = new HashMap<>();

        for(String s : strs){
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            String key = new String(charArr);

            group.putIfAbsent(key, new ArrayList());
            group.get(key).add(s);
        }

        return new ArrayList(group.values());
    }
}