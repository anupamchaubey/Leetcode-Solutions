class Solution {
    
    public String reorganizeString(String s) {
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        PriorityQueue<Character> pq=new PriorityQueue<>((a, b)-> freq[b-'a']-freq[a-'a']);

        for(int i=0;i<26;i++){
            if(freq[i]>0){
                pq.offer((char)('a'+i));
            }
        }

        StringBuilder sb=new StringBuilder();

        while(pq.size()>=2){
            char ch1=pq.poll();
            char ch2=pq.poll();

            sb.append(ch1).append(ch2);

            if(--freq[ch1-'a']>0){
                pq.offer(ch1);
            }
            if(--freq[ch2-'a']>0){
                pq.offer(ch2);
            }
        }
        while(!pq.isEmpty()){
            char ch=pq.poll();
            sb.append(ch);
            if(--freq[ch-'a']>0)return "";
        }
        return sb.toString();
    }
}