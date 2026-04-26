package math;

import java.util.*;
import java.io.*;

// 1027
public class Baek_1027 {
    static int n;
    static int[] building;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        building = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            building[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            int visibleCount = 0;
            for (int l = 1; l < i; l++) {
                boolean canVisible = true;
                long dx = i-l;
                long dy = building[i]-building[l];
                for (int x = l+1; x < i && canVisible; x++) {
                    long leftValue = dx*(building[x]-building[l]);
                    long rightValue = dy*(x-l);
                    if(leftValue>=rightValue){
                        canVisible = false;
                    }
                }
                if(canVisible){
                    visibleCount++;
                }
            }

            for (int r = n; r > i; r--) {
                boolean canVisible = true;
                long dx = r-i;
                long dy = building[r] - building[i];
                for (int x = i+1; x < r && canVisible; x++) {
                    long leftValue = dx*(building[x]-building[i]);
                    long rightValue = dy*(x-i);
                    if(leftValue>=rightValue){
                        canVisible = false;
                    }
                }
                if(canVisible){
                    visibleCount++;
                }
            }
            max = Math.max(max, visibleCount);
        }
        System.out.println(max);
    }
}
