class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> cache;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key))
            return -1;

        Node node = cache.get(key);
        removeNode(node);
        addMRUNode(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node oldNode = cache.get(key);
            removeNode(oldNode);
            cache.remove(key);
        }

        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        addMRUNode(newNode);

        if(cache.size() > capacity){
            Node lruNode = evictLRUNode();
            cache.remove(lruNode.key);
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
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private Node evictLRUNode(){
        Node lruNode = tail.prev;
        lruNode.prev.next = tail;
        tail.prev = lruNode.prev;
        return lruNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */