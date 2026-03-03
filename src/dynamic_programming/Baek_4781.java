package dynamic_programming;

import java.util.*;
import java.io.*;

// 4781
public class Baek_4781 {
    static int n;
    static int m;
    static int[] dp = new int[10_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = (int)(Double.parseDouble(st.nextToken())*100+0.5);
            if(n==0&&m==0) break;
            Arrays.fill(dp, -1);
            dp[0] = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int p = (int)(Double.parseDouble(st.nextToken())*100+0.5);
                for (int j = p; j <= m; j++) {
                    if(dp[j-p]==-1) continue;
                    dp[j] = Math.max(dp[j], dp[j-p]+c);
                }
            }
            int ans = 0;
            for (int j = 0; j <= m; j++) ans = Math.max(ans, dp[j]);
            sb.append(ans).append('\n');
        }

        System.out.println(sb);
    }
}
