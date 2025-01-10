class LRUCache {
    class Node{
        int key, value;
        Node prev, next;

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
        if(!cacheMap.containsKey(key)) return -1;

        Node node = cacheMap.get(key);
        removeNode(node);
        addMRUNode(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        Node node;
        if(cacheMap.containsKey(key)){
            node = cacheMap.get(key);
            cacheMap.remove(key);
            removeNode(node);

            node.value = value;
        }
        else{
            node = new Node(key, value);
        }
        cacheMap.put(key, node);
        addMRUNode(node);

        if(cacheMap.size() > capacity){
            Node lruNode = evictLRUNode();
            cacheMap.remove(lruNode.key);
        }
    }

    private void addMRUNode(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private Node evictLRUNode(){
        Node lruNode = tail.prev;
        removeNode(lruNode);
        return lruNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */