package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//예제 4-1 상하좌우
public class Implementation1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int startX = 1;
        int startY = 1;
        int nextX = 0;
        int nextY = 0;

        for (int i = 0; i < input.length; i++) {
            switch (input[i].charAt(0)) {
                case 'L':
                    nextX = startX + dx[0];
                    nextY = startY + dy[0];
                    break;
                case 'R':
                    nextX = startX + dx[1];
                    nextY = startY + dy[1];
                    break;
                case 'U':
                    nextX = startX + dx[2];
                    nextY = startY + dy[2];
                    break;
                case 'D':
                    nextX = startX + dx[3];
                    nextY = startY + dy[3];
                    break;
            }
            if (nextX < 1 || nextY < 1 || nextX > N || nextY > N)
                continue;
            startX = nextX;
            startY = nextY;
        }

        System.out.println(startY + " " + startX);
    }
}
