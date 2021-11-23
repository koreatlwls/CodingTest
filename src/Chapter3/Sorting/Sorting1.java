package Chapter3.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//23 국영수
public class Sorting1 {

    static class Students implements Comparable<Students> {
        String name;
        int korea;
        int english;
        int math;

        public Students(String name, int korea, int english,int math){
            this.name=name;
            this.korea=korea;
            this.english =english;
            this.math=math;
        }

        @Override
        public int compareTo(Students o) {
            if (this.korea == o.korea && this.english == o.english && this.math == o.math) {
                return this.name.compareTo(o.name);
            }
            if (this.korea == o.korea && this.english == o.english) {
                return Integer.compare(o.math, this.math);
            }
            if (this.korea == o.korea) {
                return Integer.compare(this.english, o.english);
            }
            return Integer.compare(o.korea, this.korea);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        ArrayList<Students> student = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korea = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            student.add(new Students(name,korea,english,math));
        }

        Collections.sort(student);

        for (int i = 0; i < N; i++) {
            System.out.println(student.get(i).name);
        }
    }
}
