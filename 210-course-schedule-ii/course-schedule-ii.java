class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inorder = new int[numCourses];
        List<Integer> order = new ArrayList<>();

        for(int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        for(int[] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
            inorder[pre[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < inorder.length; i++)
            if(inorder[i] == 0) queue.offer(i);

        while(!queue.isEmpty()){
            int current = queue.poll();
            order.add(current);

            for(int next : graph.get(current)){
                inorder[next]--;
                if(inorder[next] == 0) queue.offer(next);
            }
        }

        if(order.size() == numCourses){
            int[] result = new int[numCourses];
            for(int i = 0; i < numCourses; i++)
                result[i] = order.get(i);

            return result;
        }
        else return new int[0];
    }
}