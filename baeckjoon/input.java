import java.io.BufferReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        // 입력값 세팅
        BufferReader br = new BufferReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V, E; // 정점의 수, 간선의 수
        int K; // 시작 정점

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] G = new ArrayList[V+1]; // 그래프 생성
        for (int i = 1; i <= V; i++){
            G[i] = new ArrayList<int[]>();
        }

        // 그래프에 값 입ㄹ력
        for (int i = 1; i <= E; i++){
            st = new StringTokenizer(br.readLine());
            int[] tempEdge = new int[3];
            tempEdge[0] = Integer.parseInt(st.nextToken());
            tempEdge[1] = Integer.parseInt(st.nextToken());
            tempEdge[2] = Integer.parseInt(st.nextToken());

            G[tempEdge[0]].add(tempEdge);
        }
    }
}