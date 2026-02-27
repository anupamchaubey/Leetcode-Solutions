class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> shm=new HashMap<>();
        for(char ch: s.toCharArray()){
            shm.put(ch, shm.getOrDefault(ch, 0)+1);
        }

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<order.length();i++){
            if(shm.containsKey(order.charAt(i))){
                for(int p=0;p<shm.get(order.charAt(i));p++)sb.append(order.charAt(i));
            }
            shm.remove(order.charAt(i));
        }
        for(Character ch: shm.keySet()){
            for(int p=0;p<shm.get(ch);p++)sb.append(ch);
        }
        return sb.toString();
    }
}