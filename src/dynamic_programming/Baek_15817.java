package dynamic_programming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/15817
 */
public class Baek_15817 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n,x, pipe, cnt;
    static int[] dp = new int[10001];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_15817.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        dp[0] = 1;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            pipe = Integer.parseInt(st.nextToken());
            cnt = Integer.parseInt(st.nextToken());

            for(int len = x;len>=0;len--){
                int sum = 0;
                for(int use=1;use<=cnt;use++){
                    sum+=pipe;
                    if(len-sum<0) continue;
                    dp[len] += dp[len-sum];
                }
            }
        }
        System.out.println(dp[x]);
    }
}
