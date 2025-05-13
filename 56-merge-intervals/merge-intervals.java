class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> merged = new ArrayList<>();
        merged.add(new int[] {intervals[0][0], intervals[0][1]});

        for(int[] interval : intervals){
            int start = interval[0];
            int end = interval[1];
            int prevIntervalEnd = merged.get(merged.size() - 1)[1];

            if(start <= prevIntervalEnd)
                merged.get(merged.size() - 1)[1] = Math.max(end, prevIntervalEnd);
            else
                merged.add(new int[] {start, end});
        }

        return merged.toArray(new int[merged.size()][]);
    }
}