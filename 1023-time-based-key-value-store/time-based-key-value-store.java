class TimeMap {
    class TimeStore{
        String value;
        int timestamp;

        TimeStore(String value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    Map<String, List<TimeStore>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>());
        map.get(key).add(new TimeStore(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<TimeStore> values = map.get(key);
        int left = 0, right = values.size() - 1;
        String result = "";
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(values.get(mid).timestamp <= timestamp){
                result = values.get(mid).value;
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