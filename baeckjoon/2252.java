// 줄 세우기

import java.io.*;
import java.util.*;
import java.util.Stack;

class Main {
    static List<Integer>[] map;
    static int[] indegree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new ArrayList[N+1];
        visited = new boolean[N+1];
        indegree = new int[N+1];

        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }
        // 진입차수가 0이 되어 탐색순서가 도달한 정점을 담는 스택
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            indegree[b]++;
        }

        // 최초 탐색할 학생 찾기
        for (int i = 1; i < N + 1; i++) {
            if (indegree[i] == 0){
                stack.add(i);
            }
        }


        while (!stack.isEmpty()){
            int now = stack.pop();
            System.out.printf("%d ",now);

            for(int next: map[now]){
                if (indegree[next]>0){
                    indegree[next]--;
                    if (indegree[next] == 0){
                        stack.add(next);
                    }
                }
            }
        }

        System.out.println();
    }

}