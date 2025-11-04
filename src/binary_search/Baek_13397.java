package binary_search;

import java.util.*;
import java.io.*;

// 13397
public class Baek_13397 {
    static int n, m, l = 0, r = 10_000;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        while (l<=r){
            int mid = (l+r)/2;
            int cnt = 1;
            int min = nums[0], max = nums[0];

            for (int i = 1; i < n; i++) {
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i]);
                int term = max - min;
                if(term>mid){
                    min = nums[i];
                    max = nums[i];
                    cnt++;
                }
            }

            if(cnt<=m){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        System.out.println(l);
    }
}
