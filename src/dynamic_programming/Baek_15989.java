package dynamic_programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek_15989 {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br;

    static int t, n, total;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            total = 0;
            check();
        }
        System.out.println(sb);
    }

    static void check() {
        for(int twoCnt = 0; 2*twoCnt <= n; twoCnt++) {
            int remain = n-2*twoCnt;
            total += remain/3+1;
        }
        sb.append(total).append("\n");
    }
}
/*
import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[]) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(br.readLine());
      int[] dp = new int[10001];
      dp[1] = 1;
      dp[2] = 2;
      dp[3] = 3;

      for(int i = 4; i <= 10000; i++) {
          dp[i] = 1 + i / 2 + dp[i - 3];
      }

      StringBuilder answer = new StringBuilder();
      for(int tc = 0; tc < t; tc++) {
          int n = Integer.parseInt(br.readLine());
          answer.append(dp[n]).append("\n");
      }
      System.out.println(answer);
  }
}
 */
