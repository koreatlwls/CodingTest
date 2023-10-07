package october.october07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2606 {

    static int a, b;
    static int[][] map;
    static boolean[] visited;
    static int ans = 0;

    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());

        map = new int[a + 1][a + 1];
        visited = new boolean[a + 1];

        for (int i = 0; i < b; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            map[c][d] = 1;
            map[d][c] = 1;
        }

        bfs();
        System.out.println(ans - 1);
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        visited[1] = true;
        ans++;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 1; i < a + 1; i++) {
                if (map[now][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    ans++;
                }
            }
        }
    }

}
