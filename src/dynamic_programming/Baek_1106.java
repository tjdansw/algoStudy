package dynamic_programming;

import java.util.*;
import java.io.*;

public class Baek_1106 {
    static final int MAX = 100*1000;
    static int c, n;
    static int[][] node;
    static int[] dp = new int[1101];
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        node = new int[n][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            node[i][0] = Integer.parseInt(st.nextToken());
            node[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp,MAX);
        dp[0] = 0;
        for(int i = 1; i <= c+100; i++) {
            for(int j = 0;j<n; j++) {
                int prev = i - node[j][1];
                if(prev < 0) continue;
                dp[i] = Math.min(dp[i], dp[prev] + node[j][0]);
            }
        }
        System.out.println(Arrays.toString(dp));
        int min = dp[c];
        for(int i =1; i <= 100; i++) {
            min = Math.min(min, dp[c+i]);
        }
        System.out.println(min);
    }
}
