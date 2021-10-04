import java.util.*;

class Solution {
    public long solution(long price, long money, int count) {
        long answer = 0;
        long cnt = 1;
        while (count > 0){
            money -= price*cnt;
            cnt ++;
            count --;
        }
        if (money < 0) answer = -1*money;

        return answer;
    }

    public static void main(String[] args){
        int price = 3;
        int money = 20;
        int count = 4;

        System.out.print(solution(price,money,count));
    }
}
