// 최소값

import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int M;
    static int[] numbers;
    static int S;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        // 세그먼트 트리 구성
        S = 1;
        while (S < N) {
            S *= 2;
        }
        tree = new int[2 * S + 1];
        Arrays.fill(tree, Integer.MAX_VALUE);
        init();

        // 쿼리
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(query(a, b));
        }
    }

    static void init() {
        for (int i = 1; i <= N; i++) {
            int node = S + i - 1;
            tree[node] = numbers[i];
            node /= 2;
            while (node > 0) {
                tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
                node /= 2;
            }
        }

    }

    static int query(int queryLeft, int queryRight) {
        int left = S + queryLeft - 1;
        int right = S + queryRight - 1;

        int minVal = Math.min(tree[left],tree[right]);

        while (left <= right){
            if (left % 2 == 1) minVal = Math.min(minVal,tree[left++]);
            if (right % 2 == 0) minVal = Math.min(minVal,tree[right--]);
            left /= 2;
            right /= 2;
        }

        return minVal;
    }
}