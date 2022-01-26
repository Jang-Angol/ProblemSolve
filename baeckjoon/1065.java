// 한 수

import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 1 ; i <= N; i++){
            String str = Integer.toString(i);
            int d = 0;
            if (str.length()>1) d = str.charAt(0) - str.charAt(1);
            boolean success = true;
            for (int j = 1; j < str.length(); j++){
                if (d != str.charAt(j-1) - str.charAt(j)){
                    success = false;
                    break;
                }
            }
            if (success) answer ++;
        }

        System.out.println(answer);
    }
}