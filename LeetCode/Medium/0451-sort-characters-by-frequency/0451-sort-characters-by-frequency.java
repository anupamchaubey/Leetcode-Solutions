class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> hm=new HashMap<>();
        for(char ch: s.toCharArray()){
            
            char x=ch;

            hm.put(x, hm.getOrDefault(x, 0)+1);
        }
        PriorityQueue<Character> pq=new PriorityQueue<>((a, b)-> Integer.compare(hm.get(b), hm.get(a)));

        for(char ch: hm.keySet()){
            pq.offer(ch);
        }

        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            char ch=pq.poll();
            int x=hm.get(ch);
            while(x-->0){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}