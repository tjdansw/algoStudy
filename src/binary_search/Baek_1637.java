package binary_search;

import java.util.*;
import java.io.*;

// 1637
public class Baek_1637 {
    static int n;
    static long[] a, c, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new long[n];
        c = new long[n];
        b = new long[n];

        long max = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i] = Long.parseLong(st.nextToken());
            c[i] = Long.parseLong(st.nextToken());
            b[i] = Long.parseLong(st.nextToken());
            max = Math.max(max, c[i]);
        }

        long total = countLessOrEqual(max);
        if(total%2==0){
            System.out.println("NOTHING");
            return;
        }

        long l = 1, r = max;

        while (l<=r){
            long mid = (l+r)/2;
            long count = countLessOrEqual(mid);

            if(count%2==1){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(l).append(' ').append(countLessOrEqual(l)-countLessOrEqual(l-1));
        System.out.println(sb);
    }

    static long countLessOrEqual(long x) {
        long sum = 0;

        for (int i = 0; i < n; i++) {
            if (x < a[i]) continue;

            long end = Math.min(x, c[i]);
            sum += (end - a[i])/b[i] + 1;
        }

        return sum;
    }
}
