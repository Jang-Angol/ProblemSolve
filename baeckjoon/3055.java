// 탈출
import java.io.*;
import java.util.*;


class Main{
    // 상 하 좌 우
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,-1,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] strs = br.readLine().split(" ");
        Queue<Point> q = new LinkedList();

        int R = Integer.parseInt(strs[0]);
        int C = Integer.parseInt(strs[1]);

        char[][] map = new char[R][C];
        int[][] dp = new int[R][C];

        int x = 0;
        int y = 0;

        int destX = 0;
        int destY = 0;

        boolean success = false;

        for (int i = 0; i < R; i++){
            String str = br.readLine();
            map[i] = str.toCharArray();
            for (int j = 0; j < C; j++){
                if (map[i][j] == '*'){
                    q.offer(new Point(i,j,'*'));
                }
                if (map[i][j] == 'S'){
                    x = i;
                    y = j;
                }
                if (map[i][j] == 'D'){
                    destX = i;
                    destY = j;
                }
            }
        }
        int time = 0;

        q.offer(new Point(x,y,'S'));

        while (!q.isEmpty()){
            Point p = q.poll();
            x = p.x;
            y = p.y;

            //System.out.printf("x: %d y: %d time: %d\n",x,y,time);

            if (p.type=='D'){
                success = true; 
                break;
            }
            for (int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < R && 0 <= ny && ny < C){
                    if (p.type == '*' && map[nx][ny] != 'D' && map[nx][ny] != '*' && map[nx][ny] != 'X'){
                        map[nx][ny] = '*';
                        q.offer(new Point(nx,ny,map[nx][ny]));
                    } else if (p.type != '*' && dp[nx][ny] == 0 && map[nx][ny] != '*' && map[nx][ny] != 'X'){
                        q.offer(new Point(nx,ny,map[nx][ny]));
                        dp[nx][ny] = dp[x][y] + 1;
                        if (map[nx][ny] != 'D') map[nx][ny] = 'S';
                    }
                }
            }
            
            //for(int i = 0; i < R; i++){
            //    System.out.println(map[i]);
            //}
        }
        
        if (success) System.out.println(dp[destX][destY]);
        else System.out.println("KAKTUS");
    }

    
}

class Point{
    int x;
    int y;
    char type;
    Point(int x, int y, char type){
        this.x = x;
        this.y = y;
        this.type = type;
    }
}