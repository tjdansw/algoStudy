package dynamic_programming;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.io.*;

// 31565
public class Baek_31565 {
    static LocalDate jonghyun, yeongdo;
    static int t, n;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        jonghyun = LocalDate.of(year, month, day);
        st = new StringTokenizer(br.readLine());
        year = Integer.parseInt(st.nextToken());
        month = Integer.parseInt(st.nextToken());
        day = Integer.parseInt(st.nextToken());
        yeongdo = LocalDate.of(year, month, day);


        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        dp = new long[t+1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if(type==1){
                int c = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                for (int j = t; j >= c; j--) {
                    dp[j] = Math.max(dp[j], dp[j-c]+v);
                }
            }else if(type==2){
                int c = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                for (int j = t; j >= c; j--) {
                    dp[j] = Math.max(dp[j], dp[j-c]+v);
                }
            }else if(type==3){
                int c = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken())*30;
                for (int j = t; j >= c; j--) {
                    dp[j] = Math.max(dp[j], dp[j-c]+m);
                }
            }
        }
        long diff = ChronoUnit.DAYS.between(jonghyun, yeongdo);
        System.out.println(Math.abs(diff-dp[t]));
    }
}
