class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            int[] count = new int[26];
            for(char c : str.toCharArray()){
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            map.computeIfAbsent(key, k -> new ArrayList<>());
            map.get(key).add(str);
        }

        for(String key : map.keySet()){
            result.add(map.get(key));
        }

        return result;
    }
}