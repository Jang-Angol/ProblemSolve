// 초소비용 구하기

import java.io.*;
import java.util.*;

class Main {
    static int N;
    static List<Edge>[] map;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new ArrayList[N + 1];
        dp = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            map[i] = new ArrayList<>();
            dp[i] = Integer.MAX_VALUE;
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 1; i <= M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a].add(new Edge(b, c));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);
        System.out.println(dp[end]);
    }

    static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        dp[start] = 0;

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (now.cost > dp[now.node]) continue;

            for (Edge next : map[now.node]) {
                if (dp[next.node] > dp[now.node] + next.cost) {
                    dp[next.node] = dp[now.node] + next.cost;
                    pq.add(new Edge(next.node, dp[next.node]));
                }
            }
        }
    }
}

class Edge implements Comparable<Edge> {
    int node;
    int cost;

    Edge(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(cost, o.cost);
    }
}