package binary_search;

import java.util.*;
import java.io.*;

// 1561
public class Baek_1561 {
    static long n;
    static int m;
    static long[] operatingHours;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        if(n<=m){
            System.out.println(n);
            return;
        }

        operatingHours = new long[m+1];
        st = new StringTokenizer(br.readLine());
        long max = 0;
        for (int i = 1; i <= m; i++) {
            operatingHours[i] = Long.parseLong(st.nextToken());
            max = Math.max(max, operatingHours[i]);
        }

        long l = 0, r = max*n;
        while (l<=r){
            long mid = (l+r)/2;
            long maxCapacity = 0;
            for (int i = 1; i <= m; i++) {
                maxCapacity += mid/operatingHours[i] + 1;
            }

            if(maxCapacity>=n){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }

        long time = l;
        long before = getCount(time - 1);

        for (int i = 1; i <= m; i++) {
            if (time % operatingHours[i] == 0) {
                before++;
                if (before == n) {
                    System.out.println(i);
                    return;
                }
            }
        }
    }

    static long getCount(long time) {
        if (time < 0) return 0;

        long count = m;
        for (int i = 1; i <= m; i++) {
            count += time/operatingHours[i];
        }
        return count;
    }
}
