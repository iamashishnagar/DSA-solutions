class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxValue = Arrays.stream(nums).max().getAsInt();
        int[] points = new int[maxValue + 1];
        for(int num : nums)
            points[num] += num;

        int prev = 0; // i - 2
        int curr = 0; // i - 1

        for(int i = 0; i < points.length; i++){
            int temp = curr;
            curr = Math.max(points[i] + prev, curr);
            prev = temp;
        }

        return curr;
    }
}