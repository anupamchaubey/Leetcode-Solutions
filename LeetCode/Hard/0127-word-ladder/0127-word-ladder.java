class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs= new HashSet<>();
        for(String s: wordList)hs.add(s);
        Queue<String> q= new LinkedList<>();
        q.offer(beginWord);
        int level=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int l=0;l<size;l++){
                String s = q.poll();
                if(s.equals(endWord))return level;
                char[] arr=s.toCharArray();
                for(int i=0;i<arr.length;i++){
                    char orig=arr[i];
                    for(char ch='a'; ch<='z';ch++){
                        arr[i]=ch;
                        String newWord=new String(arr);
                        if(hs.contains(newWord)){
                            q.offer(newWord);
                            hs.remove(newWord);
                        }
                    }
                    arr[i]=orig;//restore
                }
            }
            level++;
        }
        return 0;
    }
}