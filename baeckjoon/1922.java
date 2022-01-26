// 네트워크 연결

import java.io.*;
import java.util.*;

// TO DP 프림으로 풀이

// 크루스칼 풀이
class Main{
    static Edge[] edgeLists; // 간선 리스트
    static int[] groups; // 서로소 여부
    static int N;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        answer = 0;

        groups = new int[N+1];
        edgeLists = new Edge[M];

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edgeLists[i] = new Edge(a,b,cost);
        }

        for (int i = 1; i <= N; i++){
            groups[i] = i;
        }

        Arrays.sort(edgeLists);

        int connectionCnt = 0;
        for (int i = 0; i < M; i++){
            if(find(edgeLists[i].a) != find(edgeLists[i].b)){
                union(edgeLists[i].a,edgeLists[i].b);
                answer += edgeLists[i].cost;
                connectionCnt++;
            }
            if (connectionCnt == N-1){
                break;
            }
        }

        System.out.println(answer);
    }

    static void union(int a, int b){
        int aGroup = find(a);
        int bGroup = find(b);

        groups[aGroup] = bGroup;
    }

    static int find(int i){
        if (groups[i] == i){
            return i;
        } else {
            return groups[i] = find(groups[i]);
        }
    }
}

class Edge implements Comparable<Edge>{
    int a;
    int b;
    int cost;

    Edge(int a, int b, int cost){
        this.a = a;
        this.b = b;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o){
        return Integer.compare(cost,o.cost);
    }

    @Override
    public String toString(){
        return this.a + " " + this.b + " " + this.cost;
    }
}