package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 로봇 청소기

public class test01 {

    private static int n;
    private static int m;
    private static Robot currentRobot;
    private static int[][] map;
    private static boolean[][] visited;
    // 북 동 남 서
    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, 1, 0, -1};
    private static int answer = 0;

    private static class Robot {
        int row;
        int col;
        int direction;

        private Robot(int row, int col, int direction) {
            this.row = row;
            this.col = col;
            this.direction = direction;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        st = new StringTokenizer(br.readLine());
        int startRow = Integer.parseInt(st.nextToken());
        int startCol = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());
        currentRobot = new Robot(startRow, startCol, direction);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
        System.out.println(answer);
    }

    private static void solve() {
        while (true) {
            cleanCurrentPosition();

            if (isClean()) {

            } else {
                int nextDirection = currentRobot.direction + 2;
                if (nextDirection >= 4) {
                    nextDirection -= 4;
                }

                int nextRow = currentRobot.row + dr[nextDirection];
                int nextCol = currentRobot.col + dc[nextDirection];

                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && map[nextRow][nextCol] == 0) {
                    currentRobot = new Robot(nextRow, nextCol, currentRobot.direction);
                } else {
                    break;
                }
            }
        }
    }

    private static void cleanCurrentPosition() {
        if (!visited[currentRobot.row][currentRobot.col]) {
            visited[currentRobot.row][currentRobot.col] = true;
            answer++;
        }
    }

    private static boolean isClean() {
        for (int i = 1; i <= 4; i++) {
            int nextDirection = currentRobot.direction - i;
            if (nextDirection < 0) {
                nextDirection += 4;
            }

            int nextRow = currentRobot.row + dr[nextDirection];
            int nextCol = currentRobot.col + dc[nextDirection];

            if (isMoving(nextRow, nextCol)) {
                currentRobot = new Robot(nextRow, nextCol, nextDirection);
                return true;
            }
        }

        return false;
    }

    private static boolean isMoving(int nextRow, int nextCol) {
        if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && !visited[nextRow][nextCol] && map[nextRow][nextCol] == 0) {
            return true;
        } else {
            return false;
        }
    }
}
