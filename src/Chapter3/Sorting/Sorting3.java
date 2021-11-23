package Chapter3.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//25 실패율
public class Sorting3 {

    static class Solution {

        static class Rate {
            int idx;
            double rate;

            public Rate(int idx, double rate) {
                this.idx = idx;
                this.rate = rate;
            }
        }

        public int[] solution(int N, int[] stages) {
            int[] user_cnt = new int[N + 2];
            int[] user_total_cnt = new int[N + 1];

            for (int i = 0; i < stages.length; i++) {
                user_cnt[stages[i]]++;
            }

            user_total_cnt[N] = user_cnt[N] + user_cnt[N + 1];
            for (int i = N - 1; i >= 1; i--) {
                user_total_cnt[i] = user_cnt[i] + user_total_cnt[i + 1];
            }

            ArrayList<Rate> arr = new ArrayList<>();
            for (int i = 1; i <= N; i++) {

                if (user_total_cnt[i] == 0) {
                    arr.add(new Rate(i, 0));
                    continue;
                }

                double rate = (double) user_cnt[i] / user_total_cnt[i];
                arr.add(new Rate(i, rate));
            }

            Collections.sort(arr, ((o1, o2) -> Double.compare(o2.rate, o1.rate)));

            int[] answer = new int[N];
            for (int i = 0; i < arr.size(); i++) {
                answer[i] = arr.get(i).idx;
            }

            return answer;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[200001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i = 0;
        while (st.hasMoreTokens()) {
            arr[i++] = Integer.parseInt(st.nextToken());
        }
        Solution sol = new Solution();
        int result[] = sol.solution(N, arr);

        for (int j = 0; j < result.length; j++) {
            System.out.print(result[j] + " ");
        }
    }
}
