import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");

        int N = Integer.parseInt(strs[0]);
        int M = Integer.parseInt(strs[1]);
        ArrayList<Integer> nums = new ArrayList<>();
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }

        int low = 0;
        int high = 1;

        while (high <= nums.size()) {
            int sum = 0;
            for (int i = low; i < high; i++) {
                sum += nums.get(i);
            }
            // sum == M -> low  ++
            if (sum == M) {
                //System.out.printf("%d %d\n",low,high);
                answer++;
                low++;
            }
            // sum > M -> low ++
            else if (sum > M) {
                low++;
            }
            // sum < M -> high ++
            else {
                high++;
            }
        }

        System.out.println(answer);
    }
}