package knapsack;

import java.util.*;
import java.io.*;

// 14728
public class Baek_14728 {
    static int n, t;
    static Unit[] testUnits;
    static int[] dp;

    static class Unit{
        int time, score;

        public Unit(int time, int score) {
            this.time = time;
            this.score = score;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        testUnits = new Unit[n];
        dp = new int[t+1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            testUnits[i] = new Unit(time, score);
        }

        for (int i = 0; i < n; i++) {
            int time = testUnits[i].time;
            int score = testUnits[i].score;
            for (int j = t; j >= time; j--) {
                dp[j] = Math.max(dp[j], dp[j-time]+score);
            }
        }
        System.out.println(dp[t]);
    }
}
