package Chapter3.DfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//19 연산자 끼워 넣기
public class DfsBfs5 {

    static int[] num;
    static int[] op = new int[4]; // 0 = 덧셈 // 1 = 뺄셈 // 2 = 곱셈 // 3 = 나눗셈
    static int n;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            num[i] = input;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(num[0],1);
        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int number, int idx) {
        if (idx == n) {
            max = Math.max(max, number);
            min = Math.min(min, number);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {

                op[i]--;
                switch (i) {
                    case 0:
                        dfs(number + num[idx], idx + 1);
                        break;
                    case 1:
                        dfs(number - num[idx], idx + 1);
                        break;
                    case 2:
                        dfs(number * num[idx], idx + 1);
                        break;
                    case 3:
                        dfs(number / num[idx], idx + 1);
                        break;
                }

                op[i]++;
            }
        }
    }
}
