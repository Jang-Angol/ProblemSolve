// 두 배열의 합

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] a = new int[1001];
        int[] b = new int[1001];

        long answer = 0;

        int T = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Long> sub_a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long sum = a[i];
            sub_a.add(sum);
            for (int j = i + 1; j < n; j++) {
                sum += a[j];
                sub_a.add(sum);
            }
        }
        Collections.sort(sub_a);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Long> sub_b = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            long sum = b[i];
            sub_b.add(sum);
            for (int j = i + 1; j < m; j++) {
                sum += b[j];
                sub_b.add(sum);
            }
        }
        Collections.sort(sub_b, Comparator.reverseOrder());

        //System.out.println(sub_a);
        //System.out.println(sub_b);

        int p1 = 0;
        int p2 = 0;

        while (p1 < sub_a.size() && p2 < sub_b.size()) {
            long currentA = sub_a.get(p1);
            long target = T - currentA;
            // currentB == target -> sub_a sub_b 같은 수 체크 -> 답을 도출 -> p1 + p2 +
            if (sub_b.get(p2) == target) {
                long countA = 0;
                long countB = 0;
                while (p1 < sub_a.size() && sub_a.get(p1) == currentA) {
                    countA++;
                    p1++;
                }
                while (p2 < sub_b.size() && sub_b.get(p2) == target) {
                    countB++;
                    p2++;
                }
                answer += countA * countB;
            }
            // currentB > target -> p2 ++
            else if (sub_b.get(p2) > target) {
                p2++;
            }
            // currentB < target -> p1 ++
            else {
                p1++;
            }
        }
        System.out.println(answer);
    }
}