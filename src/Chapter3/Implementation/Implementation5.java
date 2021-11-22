package Chapter3.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//11 뱀
public class Implementation5 {

    static int n;
    static int k;
    static int l;
    static int time;
    static int[][] board;

    static List<int[]> snake;

    static int index = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static Map<Integer, String> dir;

    public static void main(String[] args) throws Exception, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        board = new int[n + 1][n + 1];

        String str;
        int row;
        int col;
        for (int i = 0; i < k; i++) {
            str = br.readLine();

            row = Integer.parseInt(str.split(" ")[0]);
            col = Integer.parseInt(str.split(" ")[1]);

            board[row][col] = 1;
        }

        dir = new HashMap<>();
        l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            str = br.readLine();
            int timeInfo = Integer.parseInt(str.split(" ")[0]);
            String directionInfo = str.split(" ")[1];

            dir.put(timeInfo, directionInfo);
        }

        snake = new LinkedList<>();
        snake.add(new int[]{1, 1});

        time = 0;
        int nx, ny;
        int cx, cy;
        cx = 1;
        cy = 1;

        while (true) {
            time++;

            nx = cx + dx[index];
            ny = cy + dy[index];

            if (isFinish(nx, ny)) break;

            if (board[nx][ny] == 1) {
                board[nx][ny] = 0;
                snake.add(new int[]{nx, ny});
            } else {
                snake.add(new int[]{nx, ny});
                snake.remove(0);
            }

            cx = nx;
            cy = ny;

            if (dir.containsKey(time)) {
                if (dir.get(time).equals("D")) {
                    index++;
                    if (index == 4)
                        index = 0;
                }
                if (dir.get(time).equals("L")) {
                    index--;
                    if (index == -1)
                        index = 3;
                }
            }
        }
        System.out.println(time);
    }

    static boolean isFinish(int nx, int ny) {
        if (nx < 1 || ny < 1 || nx >= n + 1 || ny >= n + 1)
            return true;

        for (int i = 0; i < snake.size(); i++) {
            if (nx == snake.get(i)[0] && ny == snake.get(i)[1])
                return true;
        }

        return false;
    }
}
