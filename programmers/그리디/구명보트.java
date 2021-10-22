import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        
        Deque<Integer> q = new ArrayDeque<>();
        
        for (int i = 0; i < people.length; i++){
            q.add(people[i]);
        }
        
        int boat = 0;
        
        while (!q.isEmpty()){
            boat = q.pollLast();
            while (!q.isEmpty()&&q.peek()+boat <= limit){
                boat += q.poll();
            }
            answer += 1;
            
        }
        return answer;
    }
}