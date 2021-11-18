package Chapter3.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greedy3 {
     static String str;
     static int count0 = 0;
     static int count1 = 0;

    public static void main(String[] args) throws IOException {

     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     StringBuilder sb = new StringBuilder();
        str = br.readLine();

        if (str.charAt(0) == '1') {
            count0 += 1;
        }
        else {
            count1 += 1;
        }

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                if (str.charAt(i + 1) == '1') count0 += 1;
                else count1 += 1;
            }
        }

        System.out.println(Math.min(count0, count1));
    }
}
