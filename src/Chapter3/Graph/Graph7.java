package Chapter3.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//43 어두운 길
public class Graph7 {

    static int n, m;
    static int[] parent;
    static ArrayList<Edge> edges = new ArrayList<>();

    static class Edge implements Comparable<Edge> {
        int a;
        int b;
        int distance;

        public Edge(int a, int b, int distance) {
            this.a = a;
            this.b = b;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.distance < o.distance) {
                return -1;
            }
            return 1;
        }
    }

    static int findParent(int x) {
        if (x == parent[x]) return x;
        else return parent[x] = findParent(parent[x]);
    }

    static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            edges.add(new Edge(a, b, dist));
        }

        Collections.sort(edges);
        int total = 0;
        int result = 0;

        for (int i = 0; i < edges.size(); i++) {
            int cost = edges.get(i).distance;
            int a = edges.get(i).a;
            int b = edges.get(i).b;
            total += cost;

            if (findParent(a) != findParent(b)) {
                unionParent(a, b);
                result += cost;
            }
        }

        System.out.print(total - result);
    }
}
