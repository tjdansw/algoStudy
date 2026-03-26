package binary_search;

import java.util.*;
import java.io.*;

// 6236
public class Baek_6236 {
    static int n, m;
    static int[] dailyCosts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dailyCosts = new int[n+1];
        int l = 0, r = 1_000_000_000;
        for (int i = 1; i <= n; i++) {
            dailyCosts[i] = Integer.parseInt(br.readLine());
            l = Math.max(l, dailyCosts[i]);
        }

        while (l<=r){
            int mid = (l+r)/2;
            int money = 0;
            int withdrawCount = 0;
            for (int i = 1; i <= n;) {
                if(dailyCosts[i]>money){
                    withdrawCount++;
                    money = mid;
                    continue;
                }
                money -= dailyCosts[i];
                i++;
            }

            if(withdrawCount<=m){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        System.out.println(l);
    }
}
