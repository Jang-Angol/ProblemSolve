// 보석 도둑

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Gem> pq = new PriorityQueue<>(Comparator.comparingInt(Gem::getValue).reversed());
        List<Gem> gems = new ArrayList<>();
        List<Integer> bags = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            gems.add(new Gem(weight, value));
        }


        for (int i = 0; i < K; i++) {
            int bagSize = Integer.parseInt(br.readLine());
            bags.add(bagSize);
        }
        // 가방 오름차순 정렬
        Collections.sort(bags);
        // 보석 무게 오름차순 정렬
        Collections.sort(gems, Comparator.comparingInt(Gem::getWeight));
        // Arrays.sort(jewelries, Comparator.comparingInt(Jewelry::getWeight));
        // 보석 가격이 높은값 기준 합
        long answer = 0;
        int jIndex = 0;
        // 1. 남은 가방 중 제일 작은 가방을 선택 <-정렬
        for (int bag : bags) {
            // 선택된 가방에 넣을 수 있는 남은 보석중 가장 비싼 보석을 선택 <- 힙을 사용
            while (jIndex < N && gems.get(jIndex).weight <= bag) {
                pq.add(gems.get(jIndex));
                jIndex++;
            }

            if (!pq.isEmpty()) {
                answer += pq.poll().value;
            }

        }

        System.out.println(answer);
    }
}

class Gem {
    int weight;
    int value;

    Gem(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "weight: " + Integer.toString(this.weight) + " value: " + Integer.toString(this.value);
    }
}