import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String,Integer> map = new HashMap<>();
        
        for (int i = 0; i < participant.length; i++){
            if (map.containsKey(participant[i])){
                map.put(participant[i],map.get(participant[i])+1);
            } else {
                map.put(participant[i],1);
            }
        }
        
        for (int i = 0; i < completion.length; i++){
            map.put(completion[i],map.get(completion[i])-1);
            if (map.get(completion[i]) == 0){
                map.remove(completion[i]);
            }
        }
        
        //System.out.println(map);
        
        Iterator<String> keys = map.keySet().iterator(); 
        while (keys.hasNext()) { 
            String key = keys.next();
            answer = key;
        }
        
        return answer;
    }
}