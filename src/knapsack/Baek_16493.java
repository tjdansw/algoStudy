package knapsack;

import java.util.*;
import java.io.*;

// 16493
public class Baek_16493 {
    static int n, m;
    static Chapter[] book;
    static int[] dp;

    static class Chapter{
        int days;
        int pages;

        public Chapter(int days, int pages) {
            this.days = days;
            this.pages = pages;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        book = new Chapter[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int days = Integer.parseInt(st.nextToken());
            int pages= Integer.parseInt(st.nextToken());
            book[i] = new Chapter(days,pages);
        }
        dp = new int[n+1];
        for (int i = 0; i < m; i++) {
            Chapter c = book[i];
            for (int j = n; j >= c.days; j--) {
                dp[j] = Math.max(dp[j], dp[j-c.days]+c.pages);
            }
        }

        System.out.println(dp[n]);
    }
}
