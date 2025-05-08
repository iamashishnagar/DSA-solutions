class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for(int num : nums1) set1.add(num);

        Set<Integer> matched = new HashSet<>();
        for(int num : nums2){
            if(set1.contains(num))
                matched.add(num);
        }

        int[] result = new int[matched.size()];
        int i = 0;
        for(int match : matched){
            result[i++] = match;
        }
        return result;
    }
}