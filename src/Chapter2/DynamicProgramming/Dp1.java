package Chapter2.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//실전 문제2 1로 만들기
public class Dp1 {

    static int[] dp = new int[30001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        System.out.print(DP(N));
    }

    static int DP(int n){
        dp[0] = 0;
        dp[1] = 0;

        for(int i=2;i<=n;i++){
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0)
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if (i % 3 == 0)
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            if (i % 5 == 0)
                dp[i] = Math.min(dp[i], dp[i / 5] + 1);
        }
        return dp[n];
    }
}
