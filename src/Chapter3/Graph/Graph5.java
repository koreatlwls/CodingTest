package Chapter3.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//41 여행 계획
public class Graph5 {

    static int n, m;
    static int[] parent;

    static int findParent(int x) {
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
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

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                int input = Integer.parseInt(st.nextToken());
                if(input == 1){
                    unionParent(i,j);
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            int input = Integer.parseInt(st.nextToken());
            list.add(input);
        }

        boolean result = true;
        for(int i=0;i<list.size()-1;i++){
            if(findParent(list.get(i)) != findParent(list.get(i+1))){
                result = false;
            }
        }

        if(result){
            System.out.print("YES");
        }else{
            System.out.print("NO");
        }
    }
}
