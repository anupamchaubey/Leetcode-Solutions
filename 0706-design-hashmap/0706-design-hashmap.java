class MyHashMap {
    class Entry{
        int key;
        int value;
        Entry(int key, int val){
            this.key=key;
            this.value=val;
        }
    }
    LinkedList<Entry>[] hs;
    int BUCKET_SIZE;
    public MyHashMap() {
        hs = new LinkedList[797];
        BUCKET_SIZE = 797;
        for (int i = 0; i < BUCKET_SIZE; i++)
            hs[i] = new LinkedList<>();
    }
    
    private int hash(int key) {
        return key % BUCKET_SIZE;
    }

    public void put(int key, int value) {
        int idx = hash(key);
        for(Entry entry: hs[idx]){
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }
        hs[idx].add(new Entry(key, value));
    }
    
    public int get(int key) {
        int idx = hash(key);
        for(Entry entry: hs[idx]){
            if (entry.key == key) {
                return entry.value;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int idx = hash(key);
        for(Entry entry: hs[idx]){
            if (entry.key == key) {
                hs[idx].remove(entry);
                break;
            }
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