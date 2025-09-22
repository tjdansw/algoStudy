package dynamic_programming;

import java.util.*;
import java.io.*;

// 12852
public class Baek_12852 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n==1){
            System.out.println("0\n1");
            return;
        }
        int[] dp = new int[n+1];
        int[] prevNum = new int[n+1];
        Arrays.fill(dp, n+10);
        dp[1] = 0;

        for(int i = 1;i<n;i++){
            int next = 3 * i;
            if(next<=n&&dp[next]>dp[i]+1){
                dp[next] = dp[i]+1;
                prevNum[next] = i;
            }
            next = 2 * i;
            if(next<=n&&dp[next]>dp[i]+1){
                dp[next] = dp[i]+1;
                prevNum[next] = i;
            }
            next = i + 1;
            if(next<=n&&dp[next]>dp[i]+1){
                dp[next] = dp[i]+1;
                prevNum[next] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dp[n]).append('\n').append(n).append(' ');
        int cur = prevNum[n];
        while(true) {
            sb.append(cur).append(' ');
            if(cur == 1) break;
            cur = prevNum[cur];
        }
        System.out.println(sb);
    }
}
