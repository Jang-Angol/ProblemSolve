// 암호 만들기

import java.io.*;
import java.util.*;

class Main {
    static int L, C;
    static String[] alphabets;
    static List<String> passwords;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphabets = new String[C];
        passwords = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < C; i++) {
            alphabets[i] = st.nextToken();
        }
        Arrays.sort(alphabets);

        dfs(0,"");

        Collections.sort(passwords);

        for (String p: passwords){
            System.out.println(p);
        }

    }

    static void dfs(int s, String password) {
        if (password.length() == L) {
            int aCount = 0;
            int bCount = 0;
            for (int i = 0; i < L; i++) {
                if (password.charAt(i) == 'a' || password.charAt(i) == 'e' || password.charAt(i) == 'i' || password.charAt(i) == 'o' || password.charAt(i) == 'u') {
                    aCount++;
                } else {
                    bCount++;
                }
            }
            if (aCount > 0 && bCount > 1) passwords.add(password);
            return;
        }
        if (s >= C) {
            return;
        }
        dfs(s+1,password);
        dfs(s+1,password+alphabets[s]);
    }
}