// 최대 공약수 하나 빼기

import java.io.*;
import java.util.*;

class Main {
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        nums = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int[] leftToRight = new int[N];
        leftToRight[0] = nums[0];

        for (int i = 1; i < N; i++) {
            leftToRight[i] = gcd(leftToRight[i - 1], nums[i]);
        }

        int[] rightToLeft = new int[N];
        rightToLeft[N - 1] = nums[N - 1];

        for (int i = N - 2; i >= 0; i--) {
            rightToLeft[i] = gcd(nums[i], rightToLeft[i + 1]);
        }

        //System.out.println(Arrays.toString(leftToRight));
        //System.out.println(Arrays.toString(rightToLeft));

        int K = 0;
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int tempK = nums[i];
            int tempAnswer = 0;
            if (i == 0) {
                tempAnswer = rightToLeft[1];
            } else if (i == N - 1) {
                tempAnswer = leftToRight[N - 2];
            } else {
                tempAnswer = gcd(leftToRight[i - 1], rightToLeft[i + 1]);
            }
            if (tempK % tempAnswer != 0 && tempAnswer > answer) {
                answer = tempAnswer;
                K = tempK;
            }
        }

        if (answer ==0) System.out.println(-1);
        else System.out.printf("%d %d\n", answer, K);

    }

    // gcd( a, b ) == gcd( b, a%b ), stop a % b == 0, b -> gcd
    static int gcd(int a, int b) {
        if (b > a) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (b == 0) {
            return a;
        } else return gcd(b, a % b);
    }
}