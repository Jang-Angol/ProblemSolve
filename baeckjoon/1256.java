// 사전

import java.io.*;
import java.util.*;

class Main {
    static int[][] pascal = new int[201][201];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        /*
        // 파스칼 삼각형 -> for 문
        for (int i = 0; i < N + M + 1; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) pascal[i][j] = 1;
                else if (j == i) pascal[i][j] = 1;
                else {
                    pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
                }
            }
            //System.out.println(Arrays.toString(pascal[i]));
        }
        */
        if (K > combination(N + M, M)) {
            System.out.println("-1");
        } else {
            StringBuilder sb = new StringBuilder();
            query(N, M, K, sb);
            System.out.println(sb.toString());
        }
    }

    static void query(int n, int m, int k, StringBuilder sb) {
        // 단어 끝에 도달
        if (n + m == 0) {
            return;
        }
        // z만 남은 경우
        else if (n == 0) {
            sb.append("z");
            query(n, m - 1, k, sb);
        }
        // a만 남은 경우
        else if (m == 0) {
            sb.append("a");
            query(n - 1, m, k, sb);
        }
        // a, z 둘다 남은 경우 a를 고를 때 조합 수를 보고 판단
        else {
            // 재귀
            int leftCount = combination(n + m - 1, m);
            // 배열
            //int leftCount = pascal[n+m-2][m-1];
            if (leftCount >= k) {
                sb.append("a");
                query(n - 1, m, k, sb);
            } else {
                sb.append("z");
                query(n, m - 1, k - leftCount, sb);
            }
        }
    }

    // 파스칼 삼각형 -> 재귀
    static int combination(int n, int r) {
        if (n == r || r == 0) {
            return 1;
        } else if (pascal[n][r] != 0) {
            return pascal[n][r];
        } else {
            return pascal[n][r] = Math.min((int) 1e9, combination(n - 1, r - 1) + combination(n - 1, r));
        }
    }
}