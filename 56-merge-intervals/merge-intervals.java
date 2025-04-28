class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> output = new ArrayList<>();
        output.add(new int[] {intervals[0][0], intervals[0][1]});

        for(int[] interval : intervals){
            int start = interval[0];
            int end = interval[1];
            int lastIntervalEnd = output.get(output.size() - 1)[1];

            if(start <= lastIntervalEnd)
                output.get(output.size() - 1)[1] = Math.max(end, lastIntervalEnd);
            else
                output.add(new int[] {start, end});
        }

        return output.toArray(new int[output.size()][2]);
    }
}