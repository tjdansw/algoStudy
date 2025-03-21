package binary_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek_1300 {
    static BufferedReader br;

    static int n,k,l,r;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        int l = 1;
        int r = k;

        while(l< r) {

            int mid = (l + r)/2;

            int cnt = 0;
            for(int i = 1 ; i <= n ; i++) {
                cnt += Math.min(mid/i, n);
            }

            if(cnt >= k)
                r = mid;
            else
                l = mid+1;
        }
        System.out.println(l);
    }
}