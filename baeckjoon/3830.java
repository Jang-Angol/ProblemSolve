// 교수님은 기다리지 않는다

import java.io.*;
import java.util.*;

class Main {
    static int[] parents;
    static int[] weightDiff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        while (N != 0 && M != 0) {
            parents = new int[N + 1];
            weightDiff = new int[N + 1];

            for (int i = 0 ; i < N+1; i++){
                parents[i] = i;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                String command = st.nextToken();
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (command.equals("!")) {
                    int c = Integer.parseInt(st.nextToken());
                    union(a, b, c);
                } else {
                    if (find(a) == find(b)) {
                        long answer = weightDiff[b] - weightDiff[a];
                        System.out.println(answer);
                    } else {
                        System.out.println("UNKNOWN");
                    }
                }
            }
            // 새로운 테스트 케이스 입력
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
        }


    }

    static void union(int a, int b, int c) {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA == parentB) {
            return;
        }

        weightDiff[parentB] = weightDiff[a] - weightDiff[b] + c;
        parents[parentB] = parentA;
    }

    static int find(int i) {
        if (parents[i] == i) {
            return i;
        } else {
            int parentIndex = find(parents[i]);
            weightDiff[i] += weightDiff[parents[i]];
            return parents[i] = parentIndex;
        }
    }
}