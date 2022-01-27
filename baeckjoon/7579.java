// 앱

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] memory = new int[N + 1];
        int[] costs = new int[N + 1];
        int[][] dp;
        int answer = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        int totalCosts = 0;
        for (int i = 1; i <= N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
            totalCosts += costs[i];
        }

        dp = new int[N + 1][totalCosts + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= totalCosts; j++) {
                dp[i][j] = Math.max(dp[i][j],dp[i-1][j]); // 기초값
                if (costs[i]<=j){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-costs[i]]+memory[i]);
                }
            }
        }

        for(int i = 1; i <= totalCosts; i++){
            if (dp[N][i] >= M){
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}