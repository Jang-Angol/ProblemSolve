// 캔디 분배

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            // X: 인당 나눠줄 사탕의수
            // Y: 사탕 봉지의 수
            // AX+ 1 = BY
            // AX + BX = C의 형태로 변환
            // -AX + BY = C
            // A(-X) + BY = C
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            // 1. 해 검증
            // D = gcd(A,B) = extendedGCD(A,B).r
            // AX + BY = C 일때 C%D == 0 이어야 해를 가질 수 있음 : 배주 항등식
            // C % D != 0 -> 해가 없음
            EGResult D = extendedGCD(A, B);
            if (D.r != 1) {
                System.out.println("IMPOSSIBLE");
                continue;
            }

            //System.out.println(D);

            // 2. 초기 해 구하기
            // X0 = s * C/D
            // Y0 = t * C/D
            long x0 = D.s;
            long y0 = D.t;

            // 2. 일반해 구하기
            // X = X0 + B/D * k
            // Y = Y0 - A/D * k

            // 4. k의 범위
            // X < 0
            // X0 + B * k < 0
            // k < -X0/B

            // 0 < Y <= 1e9
            // 0 < Y0 - A*k <= 1e9
            // -Y0 < -A*k <= 1e9 - Y0
            // (Y0 - 1e9)/A <= k < Y0/A

            // (Y0 - 1e9)/A (k3) <= k < Y0/A (k1)
            //                 k < -X0/B (k2)
            long k1 = (long) (Math.ceil((double) y0 / (double) A) - 1);
            long k2 = (long) (Math.ceil((double) (-x0) / (double) B) - 1);
            long k = Math.min(k1, k2); // 최솟값 찾기
            long k3 = (long) (Math.ceil((y0 - 1e9) / (double) A));
            // 5. 만족하는 k가 있는지 찾고 k를 통해 Y를 구한다.
            if (k3 <= k) {
                long answer = y0 - A * k;
                System.out.println(answer);
                //System.out.printf("k1: %d k2: %d k3:%d\n",k1,k2,k3);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }

    }

    // 확장 유클리드 호제법
    static EGResult extendedGCD(long a, long b) {
        long s0 = 1, t0 = 0, r0 = a;
        long s1 = 0, t1 = 1, r1 = b;

        long temp;
        while (r1 != 0) {
            long q = r0 / r1;

            temp = r0 - q * r1;
            // temp = r0 % r1; // 모듈러 연산
            r0 = r1;
            r1 = temp;

            temp = s0 - q * s1;
            s0 = s1;
            s1 = temp;

            temp = t0 - q * t1;
            t0 = t1;
            t1 = temp;
        }
        return new EGResult(s0, t0, r0);
    }
}

class EGResult {
    long s;
    long t;
    long r;

    public EGResult(long s, long t, long r) {
        super();
        this.s = s;
        this.t = t;
        this.r = r;
    }

    @Override
    public String toString() {
        return "Extended GCD Result [ s = " + s + " t = " + t + " r = " + r + " ]";
    }
}