class Twitter {
    class Tweet{
        int tweetId;
        int timestamp;

        Tweet(int tweetId, int timestamp){
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
    }

    Map<Integer, List<Tweet>> tweetMap; //userId, List<Tweet>
    Map<Integer, Set<Integer>> followMap; //userId, Set<followeeId>
    int timestamp = 0;

    public Twitter() {
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new Tweet(tweetId, timestamp++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Queue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.timestamp - a.timestamp);

        if(tweetMap.containsKey(userId))
            maxHeap.addAll(tweetMap.get(userId));
        
        if(followMap.containsKey(userId)){
            for(int followeeId : followMap.get(userId))
                if(tweetMap.containsKey(followeeId))
                    maxHeap.addAll(tweetMap.get(followeeId));
        }

        List<Integer> newsFeed = new ArrayList<>();
        while(!maxHeap.isEmpty() && newsFeed.size() < 10)
            newsFeed.add(maxHeap.poll().tweetId);
        
        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId != followeeId){
            followMap.putIfAbsent(followerId, new HashSet<>());
            followMap.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId != followeeId && followMap.containsKey(followerId))
            followMap.get(followerId).remove(followeeId);        
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */