import java.util.*;

class Solution {
    
    private int answer = 0;
    
    public boolean isPrime(ArrayList<Integer> comb){
        int num = 0;
        for(int i = 0; i < comb.size(); i++)
            num += comb.get(i);
        for(int i=2; i<=num/2; i++){
            if(num % i == 0) return false;
        }
        return true;     
    }
    
    public void dfs(int[] nums, ArrayList<Integer> comb, int end){
        if (comb.size() == 3){
            //System.out.println(comb);
            if(isPrime(comb)) answer += 1;
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > end){
                ArrayList<Integer> temp_comb = new ArrayList<>();
                temp_comb.addAll(comb);
                temp_comb.add(nums[i]);
                dfs(nums,temp_comb,nums[i]);
            }
        }
        return;
    }
    public int solution(int[] nums) {
        
        ArrayList<Integer> comb = new ArrayList<>();
        dfs(nums,comb,0);

        return answer;
    }
}