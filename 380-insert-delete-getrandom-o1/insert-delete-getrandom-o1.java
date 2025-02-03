class RandomizedSet {
    Set<Integer> set;
    Random random;

    public RandomizedSet() {
        set = new HashSet<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        return set.add(val);
    }
    
    public boolean remove(int val) {
        return set.remove(val);
    }
    
    public int getRandom() {
        int randomIndex = random.nextInt(set.size());
        Iterator<Integer> iterator = set.iterator();
        while(randomIndex > 0){
            if(iterator.hasNext()) iterator.next();
            randomIndex--;
        }

        return (iterator.hasNext()) ? iterator.next() : -1;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */