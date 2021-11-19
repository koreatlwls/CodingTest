package Chapter3.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

//8 문자열 재정렬
public class Implementation2 {
    static String str;
    static ArrayList<Character> result = new ArrayList<Character>();
    static int value = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                result.add(str.charAt(i));
            } else {
                value += str.charAt(i) - '0';
            }
        }

        Collections.sort(result);

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
        }

        if (value != 0) System.out.print(value);
        System.out.println();
    }
}
