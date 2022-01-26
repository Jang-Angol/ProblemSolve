// 계단 오르기

import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N+1];
        int[][] dp = new int[N+1][2+1];

        for (int i = 1; i <= N; i++){
            score[i] = Integer.parseInt(br.readLine());
        }

        dp[1][1] = score[1];

        for (int i = 2; i <= N; i++){
            dp[i][1] = Math.max(dp[i][1],dp[i-2][1]+score[i]); // 2칸 올라오면서 밟는 경우 (직전 연속 1칸)
            dp[i][1] = Math.max(dp[i][1],dp[i-2][2]+score[i]); // 2칸 올라오면서 밟는 경우 (직전 연속 2칸)
            dp[i][2] = Math.max(dp[i][2],dp[i-1][1]+score[i]); // 1칸 올라오면서 밟는 경우 (직전 연속 1칸)
        }

        System.out.println(Math.max(dp[N][1],dp[N][2]));
    }
}