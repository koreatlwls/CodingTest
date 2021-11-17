package Chapter2.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//실전 문제2 큰 수의 법칙 방법1
public class Greedy2_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        Arrays.sort(arr);
        while (true) {
            if (M == 0)
                break;
            for (int i = 0; i < K; i++) {
                result += arr[N - 1];
                M--;
            }
            result += arr[N - 2];
            M--;
        }

        System.out.println(result);
    }
}
