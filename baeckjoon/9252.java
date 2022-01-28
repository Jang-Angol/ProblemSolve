// LCS 2

import java.io.*;
import java.util.*;

class Main {
    static char[] a;
    static int N;
    static char[] b;
    static int M;
    static int[][] dp;
    static int[][] directions;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        N = str.length();
        a = str.toCharArray();
        str = br.readLine();
        M = str.length();
        b = str.toCharArray();

        dp = new int[N + 1][M + 1];
        directions = new int[N+1][M+1];

        int fromA = 1;
        int fromB = 2;
        int equal = 3;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (dp[i-1][j] >= dp[i][j-1]){
                    directions[i][j] = fromA;
                    dp[i][j] = dp[i-1][j];
                } else{
                    directions[i][j] = fromB;
                    dp[i][j] = dp[i][j-1];
                }
                if (a[i - 1] == b[j - 1]) {
                    if (dp[i][j] < dp[i-1][j-1]+1){
                        directions[i][j] = equal;
                        dp[i][j] = dp[i-1][j-1] +1;
                    }
                }
            }
        }

        // LCS 역추적
        StringBuffer LCS = new StringBuffer();
        for(int i = N, j = M; i >= 1 && j >= 1; ){
            if(directions[i][j] == fromA){
                i--;
            }
            if (directions[i][j]==fromB){
                j--;
            }
            if (directions[i][j]==equal){
                LCS.append(a[i-1]);
                i--;
                j--;
            }
        }

        System.out.println(dp[N][M]);
        System.out.println(LCS.reverse());
    }
}