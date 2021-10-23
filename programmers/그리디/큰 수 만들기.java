import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<String> ans = new Stack<>();
        for (int i = 0; i < number.length(); i++){
            if (ans.isEmpty()){
                ans.push(Character.toString(number.charAt(i)));
                continue;
            }
            if (k > 0){
                while (!ans.isEmpty() && Integer.parseInt(ans.peek()) < Integer.parseInt(Character.toString(number.charAt(i)))){
                    if (k < 1) break;
                    ans.pop();
                    k --;
                }
            }
            ans.push(Character.toString(number.charAt(i)));
        }
        while (!ans.isEmpty()){
            String n = ans.pop();
            if (k > 0){
                k --;
                continue;
            }
            answer+=n;
        }
        StringBuffer sb = new StringBuffer(answer);
        answer = sb.reverse().toString();
        return answer;
    }
}