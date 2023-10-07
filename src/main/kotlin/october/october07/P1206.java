package october.october07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1206 {

    static int n, m, v;
    static int[][] map;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = 1;
            map[b][a] = 1;
        }

        visited = new boolean[n + 1];
        dfs(v);
        sb.append("\n");
        bfs(v);

        System.out.println(sb);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        visited = new boolean[n + 1];
        visited[start] = true;
        sb.append(start).append(" ");

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 1; i < n + 1; i++) {
                if (map[now][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    sb.append(i).append(" ");
                }
            }
        }
    }

    static void dfs(int start) {
        visited[start] = true;
        sb.append(start).append(" ");

        for (int i = 1; i < n + 1; i++) {
            if (map[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

}
