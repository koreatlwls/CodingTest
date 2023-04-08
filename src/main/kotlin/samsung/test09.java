package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// 상어 초등학교

public class test09 {

    static class Point implements Comparable<Point> {

        int row;
        int col;
        int nearCount;
        int likeCount;

        Point(int row, int col, int nearCount, int likeCount) {
            this.row = row;
            this.col = col;
            this.nearCount = nearCount;
            this.likeCount = likeCount;
        }

        @Override
        public int compareTo(Point o) {
            if (this.likeCount > o.likeCount) {
                return -1;
            } else if (this.likeCount < o.likeCount) {
                return 1;
            } else {
                if (this.nearCount > o.nearCount) {
                    return -1;
                } else if (this.nearCount < o.nearCount) {
                    return 1;
                } else {
                    if (this.row > o.row) {
                        return 1;
                    } else if (this.row < o.row) {
                        return -1;
                    } else {
                        if (this.col > o.col) {
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                }
            }
        }
    }

    static int n;
    static int[][] map;
    static int[] order;
    static List<Integer>[] list;
    static PriorityQueue<Point> queue = new PriorityQueue<>();
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];
        order = new int[n * n + 1];

        list = new ArrayList[n * n + 1];

        for (int i = 1; i <= n * n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n * n; i++) {
            String[] s = br.readLine().split(" ");
            order[i] = Integer.parseInt(s[0]);
            for (int j = 1; j < 5; j++) {
                list[Integer.parseInt(s[0])].add(Integer.parseInt(s[j]));
            }
        }

        for (int i = 1; i <= n * n; i++) {
            solve(order[i]);
            queue.clear();
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                result += getPrice(i, j);
            }
        }

        System.out.println(result);
    }

    private static void solve(int num) {
        int nextRow, nextCol;
        int nearCount, likeCount;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                nearCount = 0;
                likeCount = 0;
                if (map[i][j] != 0) {
                    continue;
                }

                for (int k = 0; k < 4; k++) {
                    nextRow = i + dr[k];
                    nextCol = j + dc[k];

                    if (nextRow >= 1 && nextRow <= n && nextCol >= 1 && nextCol <= n) {
                        for (Integer now : list[num]) {
                            if (now == map[nextRow][nextCol]) {
                                likeCount++;
                            }
                        }
                        if (map[nextRow][nextCol] == 0) {
                            nearCount++;
                        }
                    }
                }

                queue.add(new Point(i, j, nearCount, likeCount));
            }
        }

        Point poll = queue.poll();
        map[poll.row][poll.col] = num;
    }

    private static int getPrice(int row, int col) {
        int num = map[row][col];

        int nextRow, nextCol;
        int likeCount = 0;

        for (Integer now : list[num]) {
            for (int i = 0; i < 4; i++) {
                nextRow = row + dr[i];
                nextCol = col + dc[i];

                if (nextRow >= 1 && nextRow <= n && nextCol >= 1 && nextCol <= n) {
                    if (map[nextRow][nextCol] == now) {
                        likeCount++;
                    }
                }
            }
        }

        if (likeCount == 0) {
            return 0;
        } else if (likeCount == 1) {
            return 1;
        } else if (likeCount == 2) {
            return 10;
        } else if (likeCount == 3) {
            return 100;
        } else {
            return 1000;
        }
    }
}
