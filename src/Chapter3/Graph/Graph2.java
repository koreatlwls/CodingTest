package Chapter3.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//38 정확한 순위
public class Graph2 {

    static int n, m;
    static int[][] map;
    static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(map[i], INF);
        }
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                if (a == b) map[a][b] = 0;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    map[a][b] = Math.min(map[a][b], map[a][k] + map[k][b]);
                }
            }
        }

        int result = 0;
        int count;

        for (int i = 1; i <= n; i++) {
            count = 0;
            for (int j = 1; j <= n; j++) {
                if (map[i][j] != INF || map[j][i] != INF) {
                    count++;
                }
            }
            if (count == n) {
                result++;
            }
        }

        System.out.print(result);
    }
}
