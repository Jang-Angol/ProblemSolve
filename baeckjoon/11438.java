// LCA2

import java.io.*;
import java.util.*;

class Main {
    static List<Integer>[] tree;
    static int[][] parent;
    static int[] depth;
    static int logN;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        depth = new int[N + 1];

        logN = 0;
        for (int i = 1; i < N; i *= 2) {
            logN++;
        }

        parent = new int[logN+1][N + 1];

        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        // parent 채우기
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        depth[1] = 1;
        dq.add(1);
        while (!dq.isEmpty()) {
            int now = dq.poll();
            for (int next : tree[now]) {
                if (depth[next] == 0) {
                    depth[next] = depth[now] + 1;
                    parent[0][next] = now;
                    dq.add(next);
                }
            }
        }

        for (int i = 1; i <= logN; i++) {
            for (int j = 1; j <= N; j++) {
                parent[i][j] = parent[i - 1][parent[i - 1][j]];
            }
        }


        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(queryLCA(a, b));
        }

    }

    static int queryLCA(int a, int b) {
        // a의 깊이가 더 깊을 것을 가정
        if (depth[a] < depth[b]) {
            return queryLCA(b, a);
        }

        // 높이 맞추기
        for (int i = 0; i <= logN; i++) {
            if (((depth[a] - depth[b]) & (1 << i)) >= 1) {
                a = parent[i][a];
            }
        }

        // 높이가 같을 경우  같은 수인지 체크
        if (a == b) {
            return a;
        }

        // 공통 조상이 아닐때 까지 부모를 따라 올라간다.
        // 최종적으로 LCA 바로 밑칸까지 올라간다.
        for (int i = logN; i >= 0; i--) {
            if (parent[i][a] != parent[i][b]) {
                a = parent[i][a];
                b = parent[i][b];
            }
        }


        return parent[0][a];
    }
}