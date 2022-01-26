// 집합의 표현

import java.io.*;
import java.util.*;

class Main {
    static int parent[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        // 초기화
        for (int i = 0; i < n+1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (command == 0){
                union(a,b);
            } else {
                int aRoot = find(a);
                int bRoot = find(b);
                if (aRoot==bRoot) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        parent[aRoot] = bRoot;
    }

    static int find(int a){
        if (parent[a] == a) return a;
        else return parent[a] =  find(parent[a]);
    }
}