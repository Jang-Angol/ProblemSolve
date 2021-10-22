import java.util.*;

public class Main {
    static int cnt = 0;// 감염시킨 컴퓨터 수

    // dfs method
    static void dfs(int[][] a, boolean[] check, int v){
        if (check[v] == true) return; // 재귀호출 종료 후

        check[v] = true;
        cnt ++;

        for (int i = 0; i < a[v].length; i++){
            if (a[v][i] == 1 && !check[i])
                dfs(a,check,i);
        }
    }

    // main method
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt(); // 정점의 수
        int e = in.nextInt(); // 간선의 수

        int a[][] = new int[n+1][n+1]; // 그래프를 인접행렬로 표시
        boolean check[] = new boolean[n+1]; // 정점 방문 여부 배열

        for (int i = 0; i < e; i++){ // 인접행렬 초기화
            int v1 = in.nextInt();
            int v2 = in.nextInt();

            a[v1][v2] = 1;
            a[v2][v1] = 1;
        }

        dfs(a,check,1); // dfs 수행

        System.out.println(cnt-1); // 1번 컴퓨터를 제외한 감염수
    }
}