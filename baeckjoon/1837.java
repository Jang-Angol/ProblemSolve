// 암호제작

import java.io.*;
import java.util.*;

class Main {
    static boolean[] isNotPrime = new boolean[1000001];
    static List<Integer> primes = new ArrayList<>();
    static char[] P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        P = st.nextToken().toCharArray();
        int K = Integer.parseInt(st.nextToken());
        boolean fail = false;
        // 소수 구하기 -> 에라토스테네스의 채
        for (int i = 2; i < K; i++) {
            int temp_i = i;
            while (!isNotPrime[i] && temp_i + i < K) {
                temp_i += i;
                isNotPrime[temp_i] = true;
            }
            if (!isNotPrime[i]) primes.add(i);
        }
        // p q 구하기
        for (Integer prime : primes) {
            if (prime >= K) {
                break;
            }
            if (checkIsBad(prime)) {
                System.out.printf("BAD %d\n", prime);
                fail = true;
                break;
            }
        }

        if (!fail) System.out.println("GOOD");
    }

    static boolean checkIsBad(int x) {
        int r = 0;
        for (int i = 0; i < P.length; i++) {
            r = (r * 10 + (P[i] - '0')) % x;
        }
        if (r == 0) return true;
        else return false;
    }
}