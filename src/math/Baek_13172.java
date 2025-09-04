package math;

import java.util.*;
import java.io.*;

// 13172
public class Baek_13172 {
    static final int MOD = 1_000_000_007;
    static int m;
    static long res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long b = Integer.parseInt(st.nextToken());
            long a = Integer.parseInt(st.nextToken());
            long gcd = gcd(Math.max(a,b), Math.min(a,b));
            b /= gcd;
            a /= gcd;
            long inverseB = pow(b, MOD-2);
            res = (res + (a * inverseB) % MOD) % MOD;
        }
        System.out.println(res);
    }

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static long pow(long x, int y) {
        if(y == 1) return x;
        long half = pow(x, y/2);
        long res = (half * half)%MOD;

        return y%2 == 0 ? res : (res*x)%MOD;
    }
}
