package twopointer;

import java.util.*;
import java.io.*;

// 2003
public class Baek_2003 {
    static int n, m;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        int sum = 0;
        int l = 0, r= 0;
        while (true){
            if(sum>=m){
                if(sum==m){
                    cnt++;
                }
                sum -= nums[l++];
            }else{
                if(r== n){
                    break;
                }
                sum += nums[r++];
            }
        }
        System.out.println(cnt);
    }
}
