package Chapter3.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//문제1 모험가 길드
public class Greedy1 {

    static int n;
    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrayList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arrayList);

        int result = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            count++;
            if (count >= arrayList.get(i)) {
                result += 1;
                count = 0;
            }
        }

        System.out.println(result);
    }
}
