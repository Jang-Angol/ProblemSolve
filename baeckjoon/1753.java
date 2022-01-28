// 최단 경로

import java.io.*;
import java.util.*;

class Main {
    static List<Edge>[] map;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int startPoint = Integer.parseInt(br.readLine());

        map = new ArrayList[V+1];
        dp = new int[V+1];

        for (int i = 1; i<= V; i++){
            map[i] = new ArrayList<>();
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i<=E; i++){
            st = new StringTokenizer(br.readLine()," ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            map[u].add(new Edge(v,w));
        }

        dijkstra(startPoint);

        for (int i = 1; i<= V; i++){
            if (dp[i]==Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dp[i]);
        }
    }

    static void dijkstra(int startPoint){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dp[startPoint] = 0;
        pq.add(new Edge(startPoint,0));

        while (!pq.isEmpty()){
            Edge now = pq.poll();

            if (now.weight > dp[now.node]) continue;

            for(Edge next : map[now.node]){
                if(dp[next.node] > dp[now.node] + next.weight){
                    dp[next.node] = dp[now.node] + next.weight;
                    pq.add(new Edge(next.node,dp[next.node]));
                }
            }
        }
    }
}
class Edge implements Comparable<Edge> {
    int node;
    int weight;

    Edge(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(weight, o.weight);
    }
}