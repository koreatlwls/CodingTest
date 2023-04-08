package samsung;

// 마법사 상어와 비바라기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test10 {

    static class Cloud {
        int row;
        int col;

        Cloud(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int n, m;
    static int[][] map;
    static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
    static boolean[][] visited;
    static Queue<Cloud> clouds = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clouds.add(new Cloud(n - 1, 0));
        clouds.add(new Cloud(n - 1, 1));
        clouds.add(new Cloud(n - 2, 0));
        clouds.add(new Cloud(n - 2, 1));

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());

            step12(d, s);
            step34();
            step5();
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += map[i][j];
            }
        }

        System.out.println(sum);
    }

    private static void step12(int d, int s) {
        for (Cloud cloud : clouds) {
            cloud.row = (n + cloud.row + dr[d] * (s % n)) % n;
            cloud.col = (n + cloud.col + dc[d] * (s % n)) % n;
            map[cloud.row][cloud.col]++;
        }
    }

    private static void step34() {
        while (!clouds.isEmpty()) {
            Cloud cloud = clouds.poll();
            int cnt = 0;

            visited[cloud.row][cloud.col] = true;
            for (int i = 1; i <= 7; i += 2) {
                int nextRow = cloud.row + dr[i];
                int nextCol = cloud.col + dc[i];
                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n) {
                    if (map[nextRow][nextCol] >= 1) {
                        cnt++;
                    }
                }
            }

            map[cloud.row][cloud.col] += cnt;
        }
    }

    private static void step5() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] >= 2) {
                    map[i][j] -= 2;
                    clouds.add(new Cloud(i, j));
                }
            }
        }

        visited = new boolean[n][n];
    }

}
