package twopointer;

import java.util.*;
import java.io.*;

// 3273
public class Baek_3273 {
    static int n, x;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        x = Integer.parseInt(br.readLine());

        Arrays.sort(nums);
        int cnt = 0;
        int l = 0, r = n-1;
        while (l<r){
            int sum = nums[l]+nums[r];
            if(sum<=x){
                if(sum==x) {
                    cnt++;
                }
                l++;
            }else{
                r--;
            }
        }
        System.out.println(cnt);
    }
}
