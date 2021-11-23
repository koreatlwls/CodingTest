package Chapter3.DfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//20 감시 피하기
public class DfsBfs6 {

    static int N;
    static char[][] map;
    static boolean result;
    static ArrayList<Position> teachers = new ArrayList<>();

    static class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == 'T') {
                    teachers.add(new Position(i, j));
                }
            }
        }

        makeWall(0);
        if (result) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }

    static void makeWall(int depth) {

        if (depth == 3) {
            if (checkStudents()) {
                result = true;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'X') {
                    map[i][j] = 'O';
                    makeWall(depth + 1);
                    map[i][j] = 'X';
                }
            }
        }
    }

    static boolean checkStudents() {
        for (int i = 0; i < teachers.size(); i++) {
            for (int j = 0; j < 4; j++) {
                Position check = teachers.get(i);
                int x = check.x; // 세로
                int y = check.y; // 가로
                switch (j) {
                    case 0:
                        while (true) {
                            y--;
                            if (y < 0) {
                                break;
                            }
                            if (map[x][y] == 'O') {
                                break;
                            }
                            if (map[x][y] == 'S') {
                                return false;
                            }
                        }
                        break;
                    case 1:
                        while (true) {
                            y++;
                            if (y >= N) {
                                break;
                            }
                            if (map[x][y] == 'O') {
                                break;
                            }
                            if (map[x][y] == 'S') {
                                return false;
                            }
                        }
                        break;
                    case 2:
                        while (true) {
                            x++;
                            if (x >= N) {
                                break;
                            }
                            if (map[x][y] == 'O') {
                                break;
                            }
                            if (map[x][y] == 'S') {
                                return false;
                            }
                        }
                        break;
                    case 3:
                        while (true) {
                            x--;
                            if (x < 0) {
                                break;
                            }
                            if (map[x][y] == 'O') {
                                break;
                            }
                            if (map[x][y] == 'S') {
                                return false;
                            }
                        }
                        break;
                }
            }
        }
        return true;
    }
}
