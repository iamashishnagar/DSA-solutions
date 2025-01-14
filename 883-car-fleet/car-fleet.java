class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pair = new int[position.length][2];
        for(int i = 0; i < position.length; i++){
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Arrays.sort(pair, (a, b) -> b[0] - a[0]);

        float prevTime = 0.0f;
        int fleet = 0;

        for(int i = 0; i < position.length; i++){
            float currTime = (float) (target - pair[i][0]) / pair[i][1];
            if(currTime > prevTime){
                fleet++;
                prevTime = currTime;
            }
        }

        return fleet;
    }
}