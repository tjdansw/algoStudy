package dynamic_programming;

import java.util.*;
import java.io.*;

// 14002
public class Baek_14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n];
        int[] prev = new int[n];
        dp[0] = 1;
        int max = 0, idx = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            prev[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                idx = i;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        while(true){
            list.add(nums[idx]);
            if(idx == prev[idx]) {
                break;
            }
            idx = prev[idx];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n");
        for(int i = list.size() - 1; i >= 0; i--){
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}
