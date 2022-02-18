// 도로 네트워크

import java.io.*;
import java.util.*;

class Main {
    static int N, K;
    static List<Load>[] map;
    static int[][] parent;
    static int[][] minDistance;
    static int[][] maxDistance;
    static int[] depth;
    static int logN;

    static int minAnswer, maxAnswer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new ArrayList[N + 1];
        depth = new int[N + 1];

        logN = 0;
        for (int i = 1; i < N; i *= 2) {
            logN++;
        }

        parent = new int[logN + 1][N + 1];
        minDistance = new int[logN + 1][N + 1];
        maxDistance = new int[logN + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a].add(new Load(b, c));
            map[b].add(new Load(a, c));
        }

        bfs(1);
        makeSparseTable();

        int K = Integer.parseInt(br.readLine());

        for (int i = 1; i <= K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            getLCA(d, e);
            System.out.printf("%d %d\n",minAnswer,maxAnswer);
        }
    }

    static void bfs(int start) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        depth[start] = 1;
        dq.add(start);

        while (!dq.isEmpty()) {
            int now = dq.poll();
            for (Load next : map[now]) {
                if (depth[next.node] == 0) {
                    depth[next.node] = depth[now] + 1;
                    parent[0][next.node] = now;
                    minDistance[0][next.node] = next.distance;
                    maxDistance[0][next.node] = next.distance;
                    dq.add(next.node);
                }
            }
        }
    }

    static void makeSparseTable() {
        for (int i = 1; i <= logN; i++) {
            for (int j = 1; j <= N; j++) {
                parent[i][j] = parent[i - 1][parent[i - 1][j]];
                minDistance[i][j] = Math.min(minDistance[i - 1][j], minDistance[i - 1][parent[i - 1][j]]);
                maxDistance[i][j] = Math.max(maxDistance[i - 1][j], maxDistance[i - 1][parent[i - 1][j]]);
            }
        }
    }

    static int getLCA(int a, int b) {
        // a 가 b보다 깊다고 가정
        if (depth[a] < depth[b]) {
            return getLCA(b, a);
        }

        minAnswer = 1000001;
        maxAnswer = 0;

        // 높이 맞추기
        for (int i = 0; i <= logN; i++) {
            if (((depth[a] - depth[b]) & (1 << i)) >= 1) {
                minAnswer = Math.min(minAnswer, minDistance[i][a]);
                maxAnswer = Math.max(maxAnswer, maxDistance[i][a]);
                a = parent[i][a];
            }
        }

        // 높이를 맞추었다면 같은지 검사
        if (a == b) {
            return a;
        }

        // 공통조상이 아닐때 까지 부모를 따라 올라간다.
        // 최종적으로 LCA 바로 밑칸까지만 올라간다.
        for (int i = logN; i >= 0; i--){
            if(parent[i][a] != parent[i][b]){
                minAnswer = Math.min(minAnswer,Math.min(minDistance[i][a],minDistance[i][b]));
                maxAnswer = Math.max(maxAnswer,Math.max(maxDistance[i][a],maxDistance[i][b]));
                a = parent[i][a];
                b = parent[i][b];
            }
        }

        minAnswer = Math.min(minAnswer,Math.min(minDistance[0][a],minDistance[0][b]));
        maxAnswer = Math.max(maxAnswer,Math.max(maxDistance[0][a],maxDistance[0][b]));

        return parent[0][a];
    }
}

class Load {
    int node;
    int distance;

    Load(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}