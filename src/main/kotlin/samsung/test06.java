package samsung;

// 치킨 배달

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class test06 {

    static int n, m;
    static int[][] map;
    static boolean[] open;
    static int min = Integer.MAX_VALUE;
    static List<Point> house = new ArrayList<>();
    static List<Point> chicken = new ArrayList<>();

    static class Point {
        int row;
        int col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    house.add(new Point(i, j));
                } else if (map[i][j] == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }
        open = new boolean[chicken.size()];

        dfs(0, 0);
        System.out.println(min);
    }

    private static void dfs(int start, int count) {
        if (count == m) {
            calculate();
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            open[i] = true;
            dfs(i + 1, count + 1);
            open[i] = false;
        }
    }

    private static void calculate() {
        int res = 0;

        for (int i = 0; i < house.size(); i++) {
            int temp = Integer.MAX_VALUE;

            for (int j = 0; j < chicken.size(); j++) {
                if (open[j]) {
                    int dist = Math.abs(house.get(i).row - chicken.get(j).row) + Math.abs(house.get(i).col - chicken.get(j).col);
                    temp = Math.min(temp, dist);
                }
            }

            res += temp;
        }

        min = Math.min(min, res);
    }

}
