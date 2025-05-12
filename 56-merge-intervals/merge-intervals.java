class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(row -> row[0]));
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

        int[][] merged = new int[result.size()][2];
        for(int i = 0; i < result.size(); i++){
            merged[i][0] = result.get(i)[0];
            merged[i][1] = result.get(i)[1];
        }

        return merged;
    }
}