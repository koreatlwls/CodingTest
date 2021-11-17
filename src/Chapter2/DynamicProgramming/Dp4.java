package Chapter2.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//실전 문제5 효율적인 화폐 구성
public class Dp4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] money = new int[N];
        int[] dp = new int[M + 1];
        Arrays.fill(dp, 10001);
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = money[i]; j <= M; j++) {
                if (dp[j - money[i]] != 10001) {
                    dp[j] = Math.min(dp[j], dp[j - money[i]] + 1);
                }
            }
        }

        if (dp[M] == 10001) {
            System.out.println(-1);
        } else {
            System.out.println(dp[M]);
        }
    }
}
