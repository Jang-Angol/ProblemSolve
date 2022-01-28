// Dance Dance Revolution

import java.io.*;
import java.util.*;

class Main {
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        dp = new int[100000][5][5];

        int[][] costs = {
                {0, 2, 2, 2, 2},
                {2, 1, 3, 4, 3},
                {2, 3, 1, 3, 4},
                {2, 4, 3, 1, 3},
                {2, 3, 4, 3, 1}
        };

        int step = Integer.parseInt(st.nextToken());
        int index = 1;
        dp[index][step][0] = 2;
        dp[index][0][step] = 2;
        index++;

        while (step != 0) {
            for (int i = 0; i <= 4; i++) {
                for (int j = 0; j <= 4; j++) {
                    if (dp[index - 1][i][j] == 0) dp[index - 1][i][j] = Integer.MAX_VALUE;
                    if (dp[index - 1][i][j] != Integer.MAX_VALUE) {
                        if (i != step) {
                            dp[index][step][j] = Math.min(dp[index][step][j], dp[index - 1][i][j] + costs[i][step]);
                        }
                        if (j != step) {
                            dp[index][i][step] = Math.min(dp[index][i][step], dp[index - 1][i][j] + costs[j][step]);
                        }
                    }
                }
            }
            index++;
            step = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= 4; i++) {
            System.out.println(Arrays.toString(dp[1][i]));
        }
    }
}