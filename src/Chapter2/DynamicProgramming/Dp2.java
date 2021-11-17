package Chapter2.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//실전 문제3 개미 전사
public class Dp2 {

    static int[] warehouse;
    static int[] dp = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        warehouse = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            warehouse[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = warehouse[1];
        dp[2] = warehouse[2];
        for (int i = 3; i <= N; i++){
            dp[i] = Math.max(dp[i-2]+warehouse[i],dp[i-1]);
        }

        System.out.print(dp[N]);
    }
}
