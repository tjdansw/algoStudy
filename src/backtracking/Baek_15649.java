package backtracking;

import java.util.*;
import java.io.*;

// 15649
public class Baek_15649 {
    static StringBuilder sb =  new StringBuilder();
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dfs(0,new int[m], new boolean[n+1]);
        System.out.println(sb);
    }

    static void dfs(int cnt, int[] nums, boolean[] isUsed) {
        if(cnt==m){
            for(int i = 0;i<m;i++){
                sb.append(nums[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1; i<=n; i++){
            if(isUsed[i]){
                continue;
            }
            isUsed[i] = true;
            nums[cnt] = i;
            dfs(cnt+1, nums, isUsed);
            isUsed[i] = false;
        }
    }
}
