package Chapter2.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//실전 문제3 성적이 낮은 순서로 학생 출력하기
public class Sort2 {

    static class Students implements Comparable<Students>{
        int score;
        String name;

        Students(int score, String name) {
            this.score = score;
            this.name = name;
        }

        @Override
        public int compareTo(Students other) {
            if (this.score < other.score) {
                return -1;
            }
            return 1;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<Students> students = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            students.add(new Students(score, name));
        }

        Collections.sort(students);

        for (int i = 0; i < students.size(); i++) {
            System.out.print(students.get(i).getName() + " ");
        }
    }
}
