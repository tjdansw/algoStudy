package binary_search;

import java.util.*;
import java.io.*;

// 1477
public class Baek_1477 {
    static int n, m, l;
    static int[] restHouse;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        restHouse = new int[n+2];
        restHouse[n+1] = l;

        if(n!=0){
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                restHouse[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(restHouse);
        }
        int left = 1;
        int right = l;
        while (left<=right){
            int mid = (left+right)/2;
            int buildCnt = 0;

            for (int i = 0; i < n+1; i++) {
                int term = restHouse[i+1]-restHouse[i] - 1;
                buildCnt += term/mid;
            }

            if(buildCnt<=m){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        System.out.println(left);
    }
}
