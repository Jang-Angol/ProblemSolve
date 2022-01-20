// 큐

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Queue q = new Queue();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            if (command.equals("push")) {
                int val = Integer.parseInt(st.nextToken());
                q.push(val);
            } else if (command.equals("pop")) {
                System.out.println(q.pop());
            } else if (command.equals("size")) {
                System.out.println(q.size());
            } else if (command.equals("empty")) {
                System.out.println(q.empty());
            } else if (command.equals("front")) {
                System.out.println(q.front());
            } else if (command.equals("back")) {
                System.out.println(q.back());
            }
        }
    }
}

class Queue {
    List<Integer> list;

    Queue() {
        list = new ArrayList<>();
    }

    void push(int val) {
        list.add(val);
    }

    int pop() {
        if (list.isEmpty()) {
            return -1;
        } else return list.remove(0);
    }

    int size() {
        return list.size();
    }

    int empty() {
        if (list.isEmpty()) return 1;
        else return 0;
    }

    int front() {
        if (list.isEmpty()) return -1;
        else return list.get(0);
    }

    int back() {
        if (list.isEmpty()) return -1;
        else return list.get(list.size() - 1);
    }

}