// 외판원 순회

import java.io.*;
import java.util.*;

class Main {
    static int[][] graph;
    static int[][] dp;
    static int visitAll;
    static int answer;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        answer = Integer.MAX_VALUE;

        graph = new int[N + 1][N + 1];
        visitAll = (1 << N) - 1; // pow보다 성능이 더 좋다
        dp = new int[N + 1][visitAll + 1];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = 0;
        dfs(1, 1);

        System.out.println(answer);
    }

    static void dfs(int v, int visitBit) {

        if (visitBit == visitAll) {
            if (graph[v][1] == 0) {
                return; // v에서 원점으로 순회 불가능한 경우 제외
            }
            answer = Math.min(answer, dp[v][visitBit] + graph[v][1]);
        }

        for (int i = 1; i <= N; i++) {
            if ((visitBit & (1 << (i - 1))) == 0 && graph[v][i] != 0) {
                int nextBit = visitBit | (1 << (i - 1));
                if (dp[i][nextBit] > dp[v][visitBit] + graph[v][i]){
                    dp[i][nextBit] = dp[v][visitBit] + graph[v][i];
                    dfs(i,nextBit);
                }
            }
        }
    }
}