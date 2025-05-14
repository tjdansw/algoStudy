package dynamic_programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_2294 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n, k;
    static int[] dp;
    static int[] coins;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        coins = new int[n];
        dp = new int[k+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for(int i = 0;i<n;i++){
            coins[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return Integer.compare(dp[a],dp[b]);
        });
        pq.offer(0);
        while(!pq.isEmpty()){
            int cur = pq.poll();

            for(int coin : coins){
                int value = cur+coin;
                if(value<=k&&dp[value]>dp[cur]+1){
                    dp[value] = dp[cur]+1;
                    pq.offer(value);
                    if(value==k){
                        System.out.println(dp[value]);
                        return;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
