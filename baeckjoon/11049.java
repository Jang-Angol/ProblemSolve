// 행렬 곱셈 순서

import java.io.*;
import java.util.*;

class Main {
    static int[][] matrixs;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 1][N + 1];
        matrixs = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            matrixs[i][0] = Integer.parseInt(st.nextToken());
            matrixs[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = N - 1; i >= 1; i--) {// from
            for (int j = i + 1; j <= N; j++) { // to
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {// 자르는 배열
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + matrixs[i][0] * matrixs[k][1] * matrixs[j][1]);
                }
            }
        }


        System.out.println(dp[1][N]);
    }
}