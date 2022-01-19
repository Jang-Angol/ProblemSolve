// 스택

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Stack stack = new Stack();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            if (command.equals("push")) {
                int value = Integer.parseInt(st.nextToken());
                stack.push(value);
            } else if (command.equals("pop")) {
                System.out.println(stack.pop());
            } else if (command.equals("size")) {
                System.out.println(stack.size());
            } else if (command.equals("empty")) {
                System.out.println(stack.empty());
            } else if (command.equals("top")) {
                System.out.println(stack.top());
            }
        }
    }
}

class Stack {
    List<Integer> list;

    Stack() {
        list = new ArrayList<>();
    }

    void push(int val) {
        list.add(val);
    }

    int pop() {
        if (list.isEmpty()) return -1;
        return list.remove(list.size() - 1);
    }

    int size() {
        return list.size();
    }

    int empty() {
        if (list.size() > 0) return 0;
        else return 1;
    }

    int top() {
        if (list.isEmpty()) {
            return -1;
        } else {
            return list.get(list.size() - 1);
        }
    }
}