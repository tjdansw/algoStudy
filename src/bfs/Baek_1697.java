package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_1697 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n,k;
    static int[] dp = new int[200001];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        while (!q.isEmpty()) {
            int current = q.poll();
            int moveLen = dp[current]+1;
            if(isBound(current-1)&&dp[current-1]>moveLen){
                dp[current-1] = moveLen;
                q.add(current-1);
                if(current-1==k) break;
            }
            if(isBound(current+1)&&dp[current+1]>moveLen){
                dp[current+1] = moveLen;
                q.add(current+1);
                if(current+1==k) break;
            }
            if(isBound(current*2)&&dp[current*2]>moveLen){
                dp[current*2] = moveLen;
                q.add(current*2);
                if(current*2==k) break;
            }
        }
        System.out.println(dp[k]);

    }

    static boolean isBound(int x){
        return !(x<0||x>200000);
    }
}
