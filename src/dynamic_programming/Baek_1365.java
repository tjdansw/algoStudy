package dynamic_programming;

import java.util.*;
import java.io.*;

// 1365
public class Baek_1365 {
    static int n;
    static int[] electricWires, dp;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        electricWires = new int[n+1];
        dp = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            electricWires[i] = Integer.parseInt(st.nextToken());
        }

        int dpLen = 0;

        for (int i = 1; i <= n; i++) {
            if(electricWires[i]>dp[dpLen]){
                dp[++dpLen] = electricWires[i];
                continue;
            }
            int idx = binarySearch(dp, 0, dpLen, electricWires[i]);
            dp[idx] = electricWires[i];
        }
        System.out.println(n-dpLen);
    }

    static int binarySearch(int[] arr, int l, int r, int value){
        while (l<r){
            int mid = (l+r)/2;
            if(arr[mid]>=value){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return r;
    }
}
