package binary_search;

import java.util.*;
import java.io.*;

// 1818
public class Baek_1818 {
    static int n;
    static int[] lis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        lis = new int[n];
        int len = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            int l = 0, r = len;
            while (l<r){
                int mid = (l+r)/2;
                if(lis[mid]<num){
                    l = mid+1;
                }else{
                    r = mid;
                }
            }
            lis[l] = num;
            if(l == len) len++;
        }
        System.out.println(n-len);
    }
}
