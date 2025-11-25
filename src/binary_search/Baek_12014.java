package binary_search;

import java.util.*;
import java.io.*;

// 12014
public class Baek_12014 {
    static StringBuilder answer = new StringBuilder();
    static int n, k, len;
    static int[] stockPriceByDay = new int[10_000];
    static int[] LIS = new int[10_000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            answer.append("Case #").append(tc).append('\n');
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                stockPriceByDay[i] = Integer.parseInt(st.nextToken());
                LIS[i] = 0;
            }
            LIS[0] = stockPriceByDay[0];
            len = 1;
            answer.append(solve()?"1\n":"0\n");
        }
        System.out.println(answer);
    }

    static boolean solve(){
        for (int i = 1; i < n; i++) {
            if(LIS[len-1]<stockPriceByDay[i]){
                LIS[len++] = stockPriceByDay[i];
                continue;
            }
            int idx = binarySearch(stockPriceByDay[i]);
            LIS[idx] = stockPriceByDay[i];
        }
        return len>=k;
    }

    static int binarySearch(int target){
        int left = 0, right = len-1;
        while (left<right){
            int mid = (left+right)/2;
            if(target>LIS[mid]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return right;
    }
}
