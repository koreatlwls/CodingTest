package Chapter3.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//42 탑승구
public class Graph6 {

    static int g,p;
    static int[] parent =new int[100001];

    static int findParent(int x){
        if(x==parent[x])return x;
        else return parent[x] = findParent(parent[x]);
    }

    static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);

        if(a<b) parent[b] =a;
        else parent[a] = b;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        g = Integer.parseInt(br.readLine());
        p = Integer.parseInt(br.readLine());

        for(int i=1;i<=g;i++){
            parent[i] = i;
        }

        int result =0;
        for(int i=0;i<p;i++){
            int x = Integer.parseInt(br.readLine());
            int root = findParent(x);
            if(root ==0)break;
            unionParent(root,root-1);
            result++;
        }

        System.out.print(result);
    }
}
