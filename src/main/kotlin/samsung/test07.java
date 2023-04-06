package samsung;

// 인구 이동

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test07 {

    static int n, l, r;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {-1, 0, 1, 0};
    static ArrayList<Node> list;

    static class Node {
        int row;
        int col;

        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(move());
    }

    static int move() {
        int result = 0;
        while (true) {
            boolean isMove = false;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        int sum = bfs(i, j);
                        if (list.size() > 1) {
                            changePopulation(sum);
                            isMove = true;
                        }
                    }
                }
            }

            if (!isMove) return result;
            result++;
        }
    }

    static int bfs(int row, int col) {
        Queue<Node> queue = new LinkedList<>();
        list = new ArrayList<>();

        queue.add(new Node(row, col));
        list.add(new Node(row, col));
        visited[row][col] = true;

        int sum = map[row][col];

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = current.row + dr[i];
                int nextCol = current.col + dc[i];

                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n && !visited[nextRow][nextCol]) {
                    int diff = Math.abs(map[current.row][current.col] - map[nextRow][nextCol]);
                    if (l <= diff && diff <= r) {
                        queue.add(new Node(nextRow, nextCol));
                        list.add(new Node(nextRow, nextCol));
                        sum += map[nextRow][nextCol];
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
        }

        return sum;
    }

    static void changePopulation(int sum) {
        int avg = sum / list.size();
        for (Node n : list) {
            map[n.row][n.col] = avg;
        }
    }

}
