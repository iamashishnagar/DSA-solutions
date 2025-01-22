class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int[] point : points){
            int distance = (point[0] * point[0] + point[1] * point[1]);
            maxHeap.add(new int[]{distance, point[0], point[1]});
            if(maxHeap.size() > k)
                maxHeap.poll();
        }

        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++){
            int[] closest = maxHeap.poll();
            result[i][0] = closest[1];
            result[i][1] = closest[2];
        }
        
        return result;
    }
}