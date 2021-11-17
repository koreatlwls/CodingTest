package Chapter2.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//실전 문제3 떡볶이 떡 만들기
public class BinarySearch2 {

    static int[] ddeok;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ddeok = new int[N];

        int max = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ddeok[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, ddeok[i]);
        }

        System.out.print(binarySearch(0, max, M));
    }

    static int binarySearch(int start, int end, int target) {
        int mid = 0;
        int result = 0;
        int total = 0;
        while (start <= end) {
            total = 0;
            mid = (start + end) / 2;
            for (int i = 0; i < N; i++) {
                if (ddeok[i] > mid) {
                    total += ddeok[i] - mid;
                }
            }
            if (target <= total) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }
}
