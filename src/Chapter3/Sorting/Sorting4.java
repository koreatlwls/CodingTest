package Chapter3.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

//26 카드 정렬하기
public class Sorting4 {

    public static int n, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            pq.offer(input);
        }

        while (pq.size() != 1) {
            int one = pq.poll();
            int two = pq.poll();
            int summary = one + two;
            result += summary;
            pq.offer(summary);
        }

        System.out.println(result);
    }
}
