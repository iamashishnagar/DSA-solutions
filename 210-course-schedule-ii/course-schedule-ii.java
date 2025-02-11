class Solution {
    Map<Integer, List<Integer>> preMap;
    Set<Integer> visiting;
    Set<Integer> completed;
    List<Integer> order;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        preMap = new HashMap<>();
        visiting = new HashSet<>();
        completed = new HashSet<>();
        order = new ArrayList<>();

        for(int i = 0; i < numCourses; i++)
            preMap.put(i, new ArrayList<>());
        
        for(int[] pre : prerequisites)
            preMap.get(pre[0]).add(pre[1]);

        for(int course = 0; course < numCourses; course++)
            if(!canFinishCourse(course)) return new int[0];

        int[] result = new int[order.size()];
        for(int i = 0; i < result.length; i++)
            result[i] = order.get(i);

        return result;
    }

    private boolean canFinishCourse(int course){
        if(visiting.contains(course)) return false;
        if(completed.contains(course)) return true;

        visiting.add(course);

        for(int pre : preMap.get(course))
            if(!canFinishCourse(pre)) return false;
        
        visiting.remove(course);
        completed.add(course);
        order.add(course);

        return true;
    }
}