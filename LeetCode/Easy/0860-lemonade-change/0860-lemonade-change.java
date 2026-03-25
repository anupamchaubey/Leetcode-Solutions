class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0, ten=0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                five++;
            }else if(bills[i]==10){
                if(five==0)return false;
                else five--;
                ten++;
            }else{// bills[i]== 20
                if(ten>0){
                    if(five==0)return false;
                    else five--;
                    ten--;
                }else{
                    if(five<3)return false;
                    else five-=3;
                }
            }
        }
        return true;
    }
}