// 부분합
import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        ArrayList<Integer> nums = new ArrayList<>();

        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < N; i++){
            nums.add(Integer.parseInt(st.nextToken()));
        }
        nums.add(0);

        int low = 0;
        int high = 0;

        int answer = Integer.MAX_VALUE;
        int sum = nums.get(0);

        boolean success = false;

        while (low < N && high < N){
            if (sum >= S){
                answer = Math.min(high - low + 1,answer);
                success = true;
                sum -= nums.get(low++);
            } else {
                sum += nums.get(++high);
            }
        }

        if (success) System.out.println(answer);
        else System.out.println(0);
    }
}