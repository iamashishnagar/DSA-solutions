class LRUCache {
    
    class ListNode{
        int key, value;
        ListNode prev, next;

        ListNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, ListNode> cache;
    private ListNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new ListNode(0, 0);
        this.tail = new ListNode(0, 0);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key))
            return -1;
        else{
            ListNode node = cache.get(key);
            removeNode(node);
            addMRUNode(node);
            return node.value;
        }
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            ListNode oldNode = cache.get(key);
            removeNode(oldNode);
            cache.remove(key);
        }
        ListNode newNode = new ListNode(key, value);
        cache.put(key, newNode);
        addMRUNode(newNode);

        if(cache.size() > capacity){
            ListNode lruNode = evictLRUNode();
            cache.remove(lruNode.key);
        }
    }

    private void removeNode(ListNode node){
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void addMRUNode(ListNode node){
        ListNode next = head.next;
        head.next = node;
        node.next = next;
        node.prev = head;
        next.prev = node;
    }

    private ListNode evictLRUNode(){
        ListNode lruNode = tail.prev;
        tail.prev = lruNode.prev;
        lruNode.prev.next = tail;
        return lruNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */