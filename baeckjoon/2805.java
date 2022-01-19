// 나무 자르기

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Long> trees = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");

        long start = 0;
        long end = 0;

        for (int i = 0; i < N; i++) {
            long tree = Long.parseLong(st.nextToken());
            end = Math.max(end, tree);
            trees.add(tree);
        }
        Collections.sort(trees);

        long mid;

        while (start <= end) {
            long treeSize = 0;
            mid = (start + end) / 2;
            for (Long tree : trees) {
                if (mid < tree) {
                    treeSize += tree - mid;
                }
            }
            if (treeSize >= M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(end);

    }
}