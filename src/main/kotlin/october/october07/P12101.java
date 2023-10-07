package october.october07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12101 {

    static int n, k;
    static int[] history = new int[11];
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        solve(0, 0);

        if (cnt != k) {
            System.out.println(-1);
        }
    }

    static boolean solve(int node, int step) {

        if (node > n) {
            return false;
        }

        if (node == n) {
            cnt++;
            if (cnt == k) {
                for (int i = 0; i < step - 1; i++) {
                    System.out.print(history[i] + "+");
                }
                System.out.print(history[step - 1]);
                return true;
            }
        }

        for (int i = 1; i <= 3; i++) {
            history[step] = i;
            if (solve(node + i, step + 1)) return true;
        }

        return false;
    }
}
