package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//예제 4-2 시각
public class Implementation2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    String test = Integer.toString(i) + Integer.toString(j) + Integer.toString(k);
                    if (test.contains("3"))
                        cnt++;
                }
            }
        }

        System.out.print(cnt);
    }
}
