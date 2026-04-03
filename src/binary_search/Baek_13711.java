package binary_search;

import java.util.*;
import java.io.*;

// 13711
public class Baek_13711 {
    static int n;
    static int[] arr, pos, lis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        pos = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            pos[num] = i;
        }

        lis = new int[n];
        int len = 0;

        for (int i = 0; i < n; i++) {
            int x = pos[arr[i]];

            int l = 0, r = len;

            while (l<r){
                int mid = (l+r)/2;
                if(lis[mid]<x){
                    l = mid+1;
                }else{
                    r = mid;
                }
            }

            if (l == len) {
                lis[len++] = x;
            } else {
                lis[l] = x;
            }
        }

        System.out.println(len);
    }
}
