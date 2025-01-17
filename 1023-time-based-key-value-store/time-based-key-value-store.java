class TimeMap {
    class Pair{
        int timestamp;
        String value;

        Pair(int timestamp, String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList());
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Pair> values = map.get(key);
        int left = 0, right = values.size() - 1;
        String result = "";

        while(left <= right){
            int mid = left + (right - left) / 2;
            int timestampPrev = values.get(mid).timestamp;
            if(timestampPrev <= timestamp){
                result =  values.get(mid).value;
                left = mid + 1;
            }
            else right = mid - 1;
        }

        return result;

    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */