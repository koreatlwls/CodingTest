package samsung;

// 연산자 끼워넣기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test04 {

    private static int n;
    private static int[] a;
    private static int[] command;
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        command = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            command[i] = Integer.parseInt(st.nextToken());
        }

        dfs(a[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int sum, int count) {
        if (count == n) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (command[i] > 0) {
                command[i]--;

                switch (i) {
                    case 0:
                        dfs(sum + a[count], count + 1);
                        break;
                    case 1:
                        dfs(sum - a[count], count + 1);
                        break;
                    case 2:
                        dfs(sum * a[count], count + 1);
                        break;
                    case 3:
                        dfs(sum / a[count], count + 1);
                        break;
                }

                command[i]++;
            }
        }
    }

}
