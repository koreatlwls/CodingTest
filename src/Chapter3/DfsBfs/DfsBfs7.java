package Chapter3.DfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//21 인구 이동
public class DfsBfs7 {

    static int n, l, r;
    static int totalCount = 0;
    static int[][] graph = new int[50][50];
    static int[][] unions = new int[50][50];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void process(int x, int y, int index) {
        ArrayList<Position> united = new ArrayList<>();
        united.add(new Position(x, y));
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(x, y));
        unions[x][y] = index;
        int summary = graph[x][y];
        int count = 1;

        while (!q.isEmpty()) {
            Position pos = q.poll();
            x = pos.x;
            y = pos.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < n && unions[nx][ny] == -1) {
                    int gap = Math.abs(graph[nx][ny] - graph[x][y]);
                    if (l <= gap && gap <= r) {
                        q.offer(new Position(nx, ny));

                        unions[nx][ny] = index;
                        summary += graph[nx][ny];
                        count += 1;
                        united.add(new Position(nx, ny));
                    }
                }
            }
        }

        for (int i = 0; i < united.size(); i++) {
            x = united.get(i).x;
            y = united.get(i).y;
            graph[x][y] = summary / count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    unions[i][j] = -1;
                }
            }
            int index = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (unions[i][j] == -1) {
                        process(i, j, index);
                        index += 1;
                    }
                }
            }

            if (index == n * n) break;
            totalCount += 1;
        }

        System.out.println(totalCount);
    }
}