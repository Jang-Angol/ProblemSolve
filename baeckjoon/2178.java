import java.io.*;
import java.util.*;

class Main{

    static int N, M;
    
    static int[][] maze;
    static boolean[][] visited;

    static int dx[] = {0,0,-1,1};
    static int dy[] = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0,0);

        /*
        // maze check
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                System.out.printf("%d ",maze[i][j]);
            }
            System.out.println();
        }
        */
        
        System.out.println(maze[N-1][M-1]);
    }

    public static void bfs(int i, int j){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {i,j});

        while(!q.isEmpty()){
            int location[] = q.poll();
            visited[i][j] = true;

            for (int dir = 0; dir < 4; dir++){
                int x = location[0] + dx[dir];
                int y = location[1] + dy[dir];

                if (x >= 0 && y >= 0 && x < N && y < M){
                    if (maze[x][y] != 0 && !visited[x][y]){
                        q.offer(new int[] {x,y});
                        visited[x][y] = true;
                        maze[x][y] = maze[location[0]][location[1]] + 1;
                    }
                }
            }
        }
    }
}