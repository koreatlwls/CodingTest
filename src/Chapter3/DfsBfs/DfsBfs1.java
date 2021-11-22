package Chapter3.DfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//15 특정 거리의 도시 찾기
public class DfsBfs1 {

    static int n, m, k, x;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static int[] d = new int[300001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
            d[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        d[x] = 0;

        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(x);
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < graph.get(now).size(); i++) {
                int nextNode = graph.get(now).get(i);
                if (d[nextNode] == -1) {
                    d[nextNode] = d[now] + 1;
                    q.offer(nextNode);
                }
            }
        }

        boolean check = false;
        for (int i = 1; i <= n; i++) {
            if (d[i] == k) {
                System.out.println(i);
                check = true;
            }
        }

        if (!check) System.out.println(-1);
    }
}

