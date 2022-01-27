// 외판원 순회

import java.io.*;
import java.util.*;

class Main {
    static int[][] graph;
    static int[][] dp;
    static boolean[] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        graph = new int[N + 1][N + 1];
        dp = new int[N + 1][(int) Math.pow(2, N)];
        visited = new boolean[N + 1];
        // int visitAll = (1<<N)-1; // pow보다 성능이 더 좋다

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            dfs(i, 0);
        }

        /*for (int i = 1; i <= N; i++){
            System.out.println(Arrays.toString(dp[i]));
        }*/
        System.out.println(dp[N][(int)Math.pow(2,N)-1]);
    }

    static void dfs(int v, int cost) {
        int visitBit = 0;
        for (int i = 1; i <= N; i++) {
            if (visited[i]) visitBit += (int) Math.pow(2, i - 1);
        }
        if (dp[v][visitBit] == 0 || cost < dp[v][visitBit]) dp[v][visitBit] = cost;
        for (int i = 1; i <= N; i++) {
            if (graph[v][i] != 0 && !visited[i]) {
                visited[i] = true;
                dfs(i, cost + graph[v][i]);
                visited[i] = false;
            }
        }
    }
}