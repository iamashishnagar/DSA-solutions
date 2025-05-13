class LRUCache {

    class Node{
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    Map<Integer, Node> cache;
    Node head;
    Node tail;
    

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;        
    }
    
    public int get(int key) {
        if(!cache.containsKey(key))
            return -1;
        else{
            Node node = cache.get(key);
            removeNode(node);
            addMRUNode(node);
            return node.value;
        }
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            removeNode(node);
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

    private void removeNode(Node node){
        Node next = node.next;
        node.prev.next = next;
        next.prev = node.prev;
    }

    private void addMRUNode(Node node){
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
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