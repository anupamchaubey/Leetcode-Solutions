class Solution {
    class TrieNode{
        TrieNode[] children=new TrieNode[2];
    }
    TrieNode root=new TrieNode();

    void insert(int num){
        TrieNode node=root;
        
        for(int i=31;i>=0;i--){
            int bit=(num>>i) & 1;
            if(node.children[bit]==null){
                node.children[bit]=new TrieNode();
            }
            node=node.children[bit];
        }
    }
    public int findMaximumXOR(int[] nums) {
        int max=0;
        for(int i:nums){
            insert(i);
        }
        for(int i:nums){
            max=Math.max(max, maxxor(i));
        }
        return max;
    }
    int maxxor(int num){
        TrieNode node=root;
        int max=0;
        for(int i=31;i>=0;i--){
            int bit=(num>>i) & 1;

            int opposite=1-bit;

            if(node.children[opposite]!=null){
                max|=(1<<i);
                node=node.children[opposite];
            }else{
                node=node.children[bit];
            }
        }
        return max;

    }
}