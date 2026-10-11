class MyHashSet {
    LinkedList<Integer>[] hs;
    int BUCKET_SIZE;

    public MyHashSet() {
        hs = new LinkedList[797];
        BUCKET_SIZE = 797;
        for (int i = 0; i < BUCKET_SIZE; i++)
            hs[i] = new LinkedList<>();
    }

    private int hash(int key) {
        return key % BUCKET_SIZE;
    }

    public void add(int key) {
        int idx = hash(key);
        if (!hs[idx].contains(key))
            hs[idx].add(key);
    }
    public void remove(int key) {
        int idx = hash(key);
        hs[idx].remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        int idx = hash(key);
        return hs[idx].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */