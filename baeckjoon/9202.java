// Boggle

import java.io.*;
import java.util.*;

class Main {
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    static Trie root = new Trie();
    static StringBuilder sb;
    static int[] score = {0, 0, 0, 1, 1, 2, 3, 5, 11};

    static String answer;
    static boolean[][] visited;
    static char[][] map;
    static int count;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int W = Integer.parseInt(br.readLine());
        for (int i = 0; i < W; i++) {
            insertTrie(br.readLine());
        }
        br.readLine();

        int b = Integer.parseInt(br.readLine());
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < b; i++) {
            map = new char[4][4];
            visited = new boolean[4][4];
            answer = "";
            count = 0;
            sum = 0;
            sb = new StringBuilder();

            for (int j = 0; j < 4; j++) {
                String str = br.readLine();
                for (int k = 0; k < 4; k++) {
                    map[j][k] = str.charAt(k);
                }
            }

            for (int x = 0; x < 4; x++) {
                for (int y = 0; y < 4; y++) {
                    if (root.hasChild(map[x][y])) {
                        search(x, y, 1, root.getChild(map[x][y]));
                    }
                }
            }
            resultBuilder.append(sum);
            resultBuilder.append(" ");
            resultBuilder.append(answer);
            resultBuilder.append(" ");
            resultBuilder.append(count);
            resultBuilder.append("\n");
            root.clearHit();
            if (i != b - 1) br.readLine();
        }
        System.out.println(resultBuilder.toString());
    }

    static void search(int x, int y, int length, Trie node) {
        // 1. 체크인
        visited[x][y] = true;
        sb.append(map[x][y]);
        // 2. 목적지에 도착했는가? -> isEnd, isHit
        if (node.isEnd && node.isHit == false) {
            node.isHit = true;
            // 추가 답 처리
            sum += score[length];
            count++;
            String foundWord = sb.toString();
            //System.out.println(foundWord);
            if (compare(answer, foundWord) > 0) {
                answer = foundWord;
            }

        }
        // 3. 연결된 곳을 순회 -> 8방
        for (int i = 0; i < 8; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            // 4. 가능한가?
            if (0 <= ty && ty < 4 && 0 <= tx && tx < 4) {
                if (visited[tx][ty] == false && node.hasChild(map[tx][ty])) {
                    // 5. 간다
                    search(tx, ty, length + 1, node.getChild(map[tx][ty]));
                }
            }
        }
        // 6. cpzmdkdnt
        visited[x][y] = false;
        sb.deleteCharAt(length - 1);
    }

    static int compare(String arg0, String arg1) {
        int result = Integer.compare(arg1.length(), arg0.length());
        if (result == 0) {
            return arg0.compareTo(arg1);
        } else {
            return result;
        }
    }

    static void insertTrie(String word) {
        Trie current = root;
        for (int i = 0; i < word.length(); i++) {
            if (!current.hasChild(word.charAt(i))) {
                current.children[word.charAt(i) - 'A'] = new Trie();
            }
            current = current.getChild(word.charAt(i));
        }
        current.isEnd = true;
    }
}

class Trie {
    Trie[] children = new Trie[26];
    boolean isEnd;
    boolean isHit;

    boolean hasChild(char c) {
        return children[c - 'A'] != null;
    }

    Trie getChild(char c) {
        return children[c - 'A'];
    }

    void clearHit() {
        isHit = false;
        for (int i = 0; i < children.length; i++) {
            Trie child = children[i];
            if (child != null) {
                child.clearHit();
            }
        }
    }
}