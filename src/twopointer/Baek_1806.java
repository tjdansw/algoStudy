package twopointer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1806 {
    static int n, s;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        int total = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            total += nums[i];
            if(nums[i]>=s){
                System.out.println(1);
                return;
            }
        }
        if(total < s){
            System.out.println(0);
            return;
        }

        int min = n+1;
        int l = 0, r= 0, sum = 0;

        while(true){
            if(sum>=s){
                min = Math.min(min, r-l);
                sum -= nums[l++];
            }else{
                if(r==n){
                    break;
                }
                sum += nums[r++];
            }
        }
        System.out.println(min==n+1?0:min);
    }
}
