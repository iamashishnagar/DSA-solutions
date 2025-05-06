class MyHashMap {
    class Node{
        int key;
        int value;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private Node[] buckets;
    private final int SIZE = 1009; //prime number, better for even distribution

    private int hash(int key){
        return key % SIZE;
    }

    public MyHashMap() {
        buckets = new Node[SIZE];
    }
    
    public void put(int key, int value) {
        int index = hash(key);
        Node bucket = buckets[index];
        if(bucket == null){
            buckets[index] = new Node(key, value);
            return;
        }
        
        Node current = bucket;
        Node prev = null;

        while(current != null){
            if(current.key == key){
                current.value = value;
                return;
            }
            prev = current;
            current = current.next;
        }

        prev.next = new Node(key, value);       
    }
    
    public int get(int key) {
        int index = hash(key);
        Node bucket = buckets[index];
        Node current = bucket;
        
        while(current != null){
            if(current.key == key)
                return current.value;
            current = current.next;
        }

        return -1;        
    }
    
    public void remove(int key) {
        int index = hash(key);
        Node bucket = buckets[index];
        Node current = bucket;
        Node prev = null;

        while(current != null){
            if(current.key == key){
                if(prev == null) buckets[index] = current.next;
                else prev.next = current.next;
                return;
            }
            prev = current;
            current = current.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */