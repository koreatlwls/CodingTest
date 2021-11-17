package Chapter2.DfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//실전 문제3 음료수 얼려 먹기
public class Dfs1 {

    static int[][] map;
    static boolean[][] visited;
    static int cnt = 0;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dfs(i, j)) {
                    cnt++;
                }
            }
        }
        System.out.print(cnt);
    }

    static boolean dfs(int row, int col) {
        if (row < 0 || col < 0 || row >= N || col >= M) {
            return false;
        }
        if (!visited[row][col] && map[row][col] == 0) {
            visited[row][col] = true;

            dfs(row, col - 1);
            dfs(row - 1, col);
            dfs(row + 1, col);
            dfs(row, col + 1);

            return true;
        }
        return false;
    }
}
