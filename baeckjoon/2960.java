// 에라토스테네스의 체

import java.io.*;
import java.util.*;

class Main{
    static boolean[] isNotPrime = new boolean[10001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int count = 0;

        for (int i = 2; i <= N; i++){
            int temp_i = i;
            while(temp_i<= N){
                if (!isNotPrime[temp_i]) {
                    isNotPrime[temp_i] = true;
                    count ++;
                }
                if (count == K) {
                    System.out.println(temp_i);
                    return;
                }
                temp_i += i;
            }
        }
    }
}