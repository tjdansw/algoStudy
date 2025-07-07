package math;

import java.util.*;
import java.io.*;

// 9527
public class Baek_9527 {
    static long[] dp = new long[55];
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp[1] = 1;
        for(int i = 2;i<55;i++){
            dp[i] = dp[i-1]*2+(long)Math.pow(2,i-1);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a, b;
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        System.out.println(countOneBits(b)-countOneBits(a-1));
    }
    private static long countOneBits(long x) {
        long count = 0;
        for (int i = 54; i >= 0; i--) {
            if ((x & (1L << i)) != 0) {
                count += dp[i] + (x - (1L << i) + 1);
                x -= (1L << i);
            }
        }
        return count;
    }
}
