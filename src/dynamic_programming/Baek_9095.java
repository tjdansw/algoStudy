package dynamic_programming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Baek_9095 {
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] dp = new int[12];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_9095.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        dp[0]=1;
        for(int i =1;i<12;i++){
            for(int j=1;j<4;j++){
                if(i-j<0) break;
                dp[i] += dp[i-j];
            }
        }

        n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++) sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        System.out.println(sb);
    }
}
