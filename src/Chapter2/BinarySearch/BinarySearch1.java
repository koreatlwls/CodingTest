package Chapter2.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//실전 문제2 부품 찾기
public class BinarySearch1 {

    static int[] arr;
    static int[] findArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        findArr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            findArr[i] = Integer.parseInt(st.nextToken());
            if(binarySearch(0,N-1,findArr[i])){
                sb.append("yes ");
            }else {
                sb.append("no ");
            }
        }

        System.out.print(sb);
    }

    static boolean binarySearch(int start, int end, int target) {
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
