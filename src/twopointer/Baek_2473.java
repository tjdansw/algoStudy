package twopointer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_2473 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n,left, mid, right;
    static long min = Long.MAX_VALUE;
    static long[] value;
    static int[] result=new int[3];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_2473.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        value = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) value[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(value);

        left = 0;
        while(left<n-2){
            mid = left+1;
            right = n-1;
            while(mid < right) {
                long temp = value[left] + value[mid] + value[right];
                if(Math.abs(temp)<Math.abs(min)) {
                    min = temp;
                    result[0] = left;
                    result[1] = mid;
                    result[2] = right;
                    if(min==0) break;
                }
                if(temp<0){
                    mid++;
                }else{
                    right--;
                }
            }
            if(min==0) break;
            left++;
        }

        sb.append(value[result[0]]).append(' ').append(value[result[1]]).append(' ').append(value[result[2]]);
        System.out.println(sb);
    }
}
