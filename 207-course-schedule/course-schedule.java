class Solution {
    Map<Integer, List<Integer>> preMap = new HashMap<>();
    Set<Integer> visiting = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0; i < numCourses; i++){
            preMap.put(i, new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            preMap.get(pre[0]).add(pre[1]);
        }

        for(int i = 0; i < numCourses; i++){
            if(!canFinishAllCourses(i))
                return false;
        }

        return true;
    }

    private boolean canFinishAllCourses(int course){
        if(visiting.contains(course)) return false;
        if(preMap.get(course).isEmpty()) return true;

        visiting.add(course);
        
        for(int pre : preMap.get(course)){
            if(!canFinishAllCourses(pre))
                return false;
        }

        visiting.remove(course);
        preMap.put(course, new ArrayList<>());

        return true;
    }
}