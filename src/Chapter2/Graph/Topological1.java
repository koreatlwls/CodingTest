package Chapter2.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//실전 문제4 커리큘럼
public class Topological1 {

    static int v;
    static int[] indegree = new int[501];
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static int[] times = new int[501];


    static void topologySort() {
        int[] result = new int[501];
        for (int i = 1; i <= v; i++) {
            result[i] = times[i];
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= v; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < graph.get(now).size(); i++) {
                result[graph.get(now).get(i)] = Math.max(result[graph.get(now).get(i)], result[now] + times[graph.get(now).get(i)]);
                indegree[graph.get(now).get(i)] -= 1;

                if (indegree[graph.get(now).get(i)] == 0) {
                    q.offer(graph.get(now).get(i));
                }
            }
        }

        for (int i = 1; i <= v; i++) {
            System.out.println(result[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        v = Integer.parseInt(br.readLine());

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 1; i <= v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            times[i] = x;
            while (true) {
                x = Integer.parseInt(st.nextToken());
                if (x == -1) break;
                indegree[i] += 1;
                graph.get(x).add(i);
            }
        }

        topologySort();
    }
}
