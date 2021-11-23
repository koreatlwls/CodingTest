package Chapter3.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//29 공유기 설치
public class BinarySearch3 {

    static int n, c;
    static int[] arr;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int start = 1;
        int end = arr[n - 1] - arr[0];
        binarySearch(start, end);
        System.out.print(result);
    }

    static void binarySearch(int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            int value = arr[0];
            int cnt = 1;

            for (int i = 1; i < n; i++) {
                if (arr[i] >= value + mid) {
                    value = arr[i];
                    cnt++;
                }
            }

            if (cnt >= c) {
                start = mid + 1;
                result = mid;
            } else {
                end = mid - 1;
            }
        }
    }
}
