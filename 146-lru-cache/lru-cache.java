class LRUCache {
    class Node{
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, Node> cacheMap;
    int capacity;
    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;        
    }
    
    public int get(int key) {
        if(!cacheMap.containsKey(key))
            return -1;
        
        Node node = cacheMap.get(key);
        removeNode(node);
        addMRUNode(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if(cacheMap.containsKey(key)){
            Node oldNode = cacheMap.get(key);
            cacheMap.remove(key);
            removeNode(oldNode);
        }
        Node newNode = new Node(key, value);
        cacheMap.put(key, newNode);
        addMRUNode(newNode);

        if(cacheMap.size() > capacity){
            Node lru = evictLRUNode();
            cacheMap.remove(lru.key);
        }
    }

    private void addMRUNode(Node node){
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }

    private void removeNode(Node node){
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }

    private Node evictLRUNode(){
        Node lru = tail.prev;
        Node newLRU = lru.prev;
        newLRU.next = tail;
        tail.prev = newLRU;

        return lru;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */