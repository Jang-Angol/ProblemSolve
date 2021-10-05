import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        for (int i = 0; i < phone_book.length - 1; i++) {
            String pre = phone_book[i];
            boolean contains = true;
            for (int j = 0; j < pre.length(); j++){
                if (pre.charAt(j) != phone_book[i+1].charAt(j)){
                    contains = false;
                    break;
                }
            }
            if (contains) {
                return false;
            }
        }
        
        return answer;
    }
}