class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();
        result.add(new int[] {intervals[0][0], intervals[0][1]});

        for(int[] interval : intervals){
            int start = interval[0];
            int end = interval[1];
            int lastIntervalEnd = result.get(result.size() - 1)[1];

            if(start <= lastIntervalEnd)
                result.get(result.size() - 1)[1] = Math.max(end, lastIntervalEnd);
            else
                result.add(new int[] {start, end});
        }

        return result.toArray(new int[result.size()][2]);
    }
}