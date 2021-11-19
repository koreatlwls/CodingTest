package Chapter3.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//7 럭키 스트레이트
public class Implementation1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String n = br.readLine();
        int leftResult = 0;
        int rightResult = 0;
        for (int i = 0; i < n.length(); i++) {
            if (i < n.length() / 2) {
                leftResult += n.charAt(i) - '0';
            } else {
                rightResult += n.charAt(i) - '0';
            }
        }

        if (leftResult == rightResult) {
            System.out.print("LUCKY");
        } else {
            System.out.print("READY");
        }
    }
}
