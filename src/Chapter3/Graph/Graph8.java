package Chapter3.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Graph8 {

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
            if (this.distance < o.distance) return -1;
            return 1;
        }
    }

    static class Position implements Comparable<Position> {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Position o) {
            if (this.x == o.x) {
                return Integer.compare(this.y, o.y);
            }
            return Integer.compare(this.x, o.x);
        }
    }

    static int n;
    static int[] parent = new int[100001];
    static ArrayList<Edge> edges = new ArrayList<>();
    static int result = 0;

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

        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        ArrayList<Position> x = new ArrayList<>();
        ArrayList<Position> y = new ArrayList<>();
        ArrayList<Position> z = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            x.add(new Position(a, i));
            y.add(new Position(b, i));
            z.add(new Position(c, i));
        }

        Collections.sort(x);
        Collections.sort(y);
        Collections.sort(z);

        for (int i = 0; i < n - 1; i++) {
            edges.add(new Edge(x.get(i).y, x.get(i + 1).y, x.get(i + 1).x - x.get(i).x));
            edges.add(new Edge(y.get(i).y, y.get(i + 1).y, y.get(i + 1).x - y.get(i).x));
            edges.add(new Edge(z.get(i).y, z.get(i + 1).y, z.get(i + 1).x - z.get(i).x));
        }

        Collections.sort(edges);

        for (int i = 0; i < edges.size(); i++) {
            int cost = edges.get(i).distance;
            int a = edges.get(i).a;
            int b = edges.get(i).b;

            if (findParent(a) != findParent(b)) {
                unionParent(a, b);
                result += cost;
            }
        }

        System.out.print(result);
    }
}
