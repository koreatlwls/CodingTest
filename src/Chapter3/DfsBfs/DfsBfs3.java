package Chapter3.DfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//17 경쟁적 전염
public class DfsBfs3 {

    static int N, K, S, X, Y;
    static int map[][];
    static PriorityQueue<Data> pq;
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};

    static class Data implements Comparable<Data> {
        int x;
        int y;
        int type;
        int gen;

        public Data(int x, int y, int type, int gen) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.gen = gen;
        }

        @Override
        public int compareTo(Data o) {
            if (this.gen - o.gen == 0) {
                return this.type - o.type;
            }
            return this.gen - o.gen;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>();
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    pq.add(new Data(i, j, map[i][j], 0));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        if (S != 0) {
            spread();
        }

        System.out.println(map[X - 1][Y - 1]);
    }

    static void spread() {
        Data cur = null;

        while (!pq.isEmpty()) {
            cur = pq.poll();

            if (cur.gen == S)
                return;

            for (int dir = 0; dir < 4; dir++) {
                int nr = cur.x + dr[dir];
                int nc = cur.y + dc[dir];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N)
                    continue;

                if (map[nr][nc] != 0)
                    continue;

                map[nr][nc] = cur.type;
                pq.add(new Data(nr, nc, map[nr][nc], cur.gen + 1));
            }
        }
    }
}
