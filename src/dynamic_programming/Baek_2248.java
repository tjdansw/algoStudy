package dynamic_programming;

import java.util.*;
import java.io.*;

// 2248
public class Baek_2248 {
    static int N, L;
    static long I;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        I = Long.parseLong(st.nextToken());
        // 1~i번째 자리에 1의 개수가 j개 있을 경우의 수
        dp = new long[N + 1][N + 1];
        dp[0][0] = 1;
        dp[1][1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i][1] = 1;
            dp[i][i] = dp[i - 1][i - 1];
            for (int j = 2; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        int target = 0;
        while(true){
            long total = 0;
            for (int i = 0; i <= L; i++) {
                total += dp[target][i];
            }
            if(I-total<=0){
                break;
            }
            I -= total;
            target++;
        }

        int number = (int)Math.pow(2,target-1);
        while(true){
            int bitCount = Integer.bitCount(number);
            if(bitCount<=L){
                I--;
            }
            if(I==0) break;
            number++;
        }
        String binary = Integer.toBinaryString(number);
        String result = String.format("%" + N + "s", binary).replace(' ', '0');
        System.out.println(result);
    }
}
