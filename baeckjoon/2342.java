// Dance Dance Revolution

import java.io.*;
import java.util.*;

class Main {
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = st.countTokens();

        dp = new int[N + 1][5][5];

        int[][] costs = {
                {0, 2, 2, 2, 2},
                {3, 1, 3, 4, 3},
                {3, 3, 1, 3, 4},
                {3, 4, 3, 1, 3},
                {3, 3, 4, 3, 1}
        };

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= 4; j++) {
                for (int k = 0; k <= 4; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        int step = Integer.parseInt(st.nextToken());
        int index = 1;
        dp[index][step][0] = 2;
        dp[index][0][step] = 2;

        while (true) {
            step = Integer.parseInt(st.nextToken());
            if (step == 0) break;
            for (int i = 0; i <= 4; i++) {
                for (int j = 0; j <= 4; j++) {
                    if (dp[index][i][j] != Integer.MAX_VALUE) { // 여기까지 밟는 방법이 있을 경우에만 계산
                        if (j != step) {// 왼발로 밟기 (두 발이 같은 위치에 있으면 안됨)
                            dp[index + 1][step][j] = Math.min(dp[index + 1][step][j], dp[index][i][j] + costs[i][step]);
                        }
                        if (i != step) {// 오른발로 밟기 (두 발이 같은 위치에 있으면 안됨)
                            dp[index + 1][i][step] = Math.min(dp[index + 1][i][step], dp[index][i][j] + costs[j][step]);
                        }
                    }
                }
            }
            index++;
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i<=4;i++){
            for(int j = 0; j<=4;j++){
                answer = Math.min(answer,dp[index][i][j]);
            }
        }
        System.out.println(answer);
    }
}