// 사탕 상자

import java.io.*;
import java.util.*;

class Main {
    static long[] tree;
    static int S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        S = (int) Math.pow(2,20);
        tree = new long[2 * S + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if (A == 1) {
                System.out.println(query(1, S, 1, B));
                //System.out.println(Arrays.toString(tree));
            } else {
                long C = Long.parseLong(st.nextToken());
                update(1, S, 1, B, C);
                //System.out.println(Arrays.toString(tree));
            }
        }
    }

    static long query(int left, int right, int node, int rank) {
        if (tree[node] < rank)
            return 0;
        else if (left == right) {
            tree[node]--;
            return left;
        } else {
            tree[node]--;
            int mid = (left + right) / 2;
            if (tree[node * 2] >= rank) {
                return query(left, mid, node * 2, rank);
            } else {
                return query(mid + 1, right, node * 2 + 1, rank - (int) tree[node * 2]);
            }
        }
    }

    static void update(int left, int right, int node, int target, long diff) {
        if (target < left || right < target) {
            return;
        } else {
            tree[node] += diff;
            if (left != right) {
                int mid = (left + right) / 2;
                update(left, mid, node * 2, target, diff);
                update(mid + 1, right, node * 2 + 1, target, diff);
            }
        }
    }
}