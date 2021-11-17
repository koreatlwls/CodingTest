package Chapter2.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//실전 문제4 두 배열의 원소 교체
public class Sort3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Integer[] arrA = new Integer[N];
        Integer[] arrB = new Integer[N];

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (i == 0)
                    arrA[j] = Integer.parseInt(st.nextToken());
                else
                    arrB[j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(arrA);
        Arrays.sort(arrB, Collections.reverseOrder());

        for (int i = 0; i < K; i++) {
            if (arrA[0] < arrB[0]) {
                int tmp = arrA[0];
                arrA[0] = arrB[0];
                arrB[0] = tmp;
            }
            Arrays.sort(arrA);
            Arrays.sort(arrB, Collections.reverseOrder());
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            result += arrA[i];
        }
        System.out.print(result);
    }
}
