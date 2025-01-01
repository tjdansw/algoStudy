package dynamic_programming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_10942 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n, m, s, e;
    static int[] nums;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_10942.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        nums = new int[n + 1];
        dp = new int[n + 1][n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
            for(int j = 1; j <= i; j++){
                if(i==j) dp[i][j] = 1;
                else if(i-j==1) dp[i][j] = nums[i]==nums[j]?1:0;
                else{ // 구간 양 끝값이 같은지 && 양끝을 제외한 구간을 비교한 dp값이 1인지
                    dp[i][j] = (nums[i]==nums[j]&&dp[i-1][j+1]==1)?1:0;
                }
            }
        }

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            sb.append(dp[e][s]).append("\n");
        }
        System.out.println(sb);
    }
}
