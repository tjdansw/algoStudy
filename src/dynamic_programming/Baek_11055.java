package dynamic_programming;

import java.util.*;
import java.io.*;

// 11055
public class Baek_11055 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n+1];
        int max = 0;
        for(int i = 0; i < n; i++){
            dp[i+1] = nums[i];
            for(int j = 0;j<i;j++){
                if(nums[j] < nums[i]){
                    dp[i+1] = Math.max(dp[i+1], dp[j+1]+nums[i]);
                }
            }
            max = Math.max(max, dp[i+1]);
        }
        System.out.println(max);
    }
}
