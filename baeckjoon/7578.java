// 공장

import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[] machinesA;
    static HashMap<Integer, Integer> machinesB;
    static int S;
    static long[] tree;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        machinesA = new int[N + 1];
        machinesB = new HashMap<>();
        S = 1;
        while (S < N) {
            S *= 2;
        }
        tree = new long[2*S];
        answer = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            machinesA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            int key = Integer.parseInt(st.nextToken());
            machinesB.put(key, i);
        }

        int index;
        for (int i = 1; i <= N; i++){
            index = machinesB.get(machinesA[i]);
            answer += query(index+1,N);
            update(index,1);
        }

        System.out.println(answer);
    }

    static long query(int queryLeft, int queryRight){
        int left = S + queryLeft - 1;
        int right = S + queryRight - 1;

        long sum = 0;
        while (left <= right){
            if (left%2 == 1){
                sum += tree[left++];
            }
            if (right %2 == 0){
                sum += tree[right--];
            }
            left /= 2;
            right /= 2;
        }
        return sum;
    }

    static void update(int target, int value){
        int node = S + target - 1;
        tree[node] += value;
        node /= 2;
        while (node>0){
            tree[node] = tree[node*2] + tree[node*2+1];
            node /= 2;
        }
    }
}