package dynamic_programming;

import java.util.*;
import java.io.*;

// 24395
public class Baek_24395 {
    static int n, m;
    static Prescription[] prescriptions;
    static int[][] dp = new int[51][51];;
    static List<State> list = new ArrayList<>();

    static class Prescription{
        int red, blue, danger;

        public Prescription(int red, int blue, int danger) {
            this.red = red;
            this.blue = blue;
            this.danger = danger;
        }
    }

    static class State{
        int num, danger;

        public State(int num, int danger) {
            this.num = num;
            this.danger = danger;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        prescriptions = new Prescription[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            prescriptions[i] = new Prescription(r, b, d);
        }
        for (int i = 0; i < 51; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 0;

        for (int i = 0; i < m; i++) {
            int r = prescriptions[i].red;
            int b = prescriptions[i].blue;
            int d = prescriptions[i].danger;

            for (int rr = 50; rr >= r; rr--) {
                for (int bb = 50; bb >= b; bb--) {
                    if (dp[rr - r][bb - b] == -1) continue;
                    dp[rr][bb] = Math.max(dp[rr][bb], dp[rr - r][bb - b] + d);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int danger = dp[r][b];
            if (danger == -1) danger = 0;
            list.add(new State(i, danger));
        }
        list.sort((a, b)->{
            if(a.danger==b.danger) return Integer.compare(a.num, b.num);
            return Integer.compare(a.danger, b.danger);
        });

        StringBuilder sb = new StringBuilder();
        for (State s : list) {
            sb.append(s.num).append(' ').append(s.danger).append('\n');
        }
        System.out.print(sb);
    }
}
