package twopointer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1806 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n, s,l,r, sum = 0, min = 100000001;
    static int[] nums;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_1806.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        nums = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        l = 0;
        r = 0;
        while(r<=n){
            if(sum>=s){
                min = Math.min(min,r-l+1);
                sum -= nums[l];
                l++;
            }else{
                if(r==n) break;
                r++;
                sum+= nums[r];
            }
        }
        System.out.println(min==100000001?0:min);
    }
}
