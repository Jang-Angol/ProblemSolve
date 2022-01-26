// 정수 삼각형

import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] numbers = new int[n+1+1][n+1+1];
        int[][] dp = new int[n+1+1][n+1+1];

        for (int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 1; j <= i; j++){
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= i; j++){
                dp[i][j] = numbers[i][j] + Integer.max(dp[i-1][j-1],dp[i-1][j]);
            }
        }

        Arrays.sort(dp[n]);

        System.out.println(dp[n][n+1]);

    }
}