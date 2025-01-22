class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        for(int[] point : points){
            double distance = Math.sqrt(point[0] * point[0] + point[1] * point[1]);
            maxHeap.add(new double[]{distance, point[0], point[1]});
            if(maxHeap.size() > k)
                maxHeap.poll();
        }

        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++){
            double[] closest = maxHeap.poll();
            result[i][0] = (int) closest[1];
            result[i][1] = (int) closest[2];
        }
        
        return result;
    }
}