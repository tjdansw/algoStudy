package divide_conquer;

import java.util.*;
import java.io.*;

// 11444
public class Baek_11444 {
    static HashMap<Long,Long> map = new HashMap<>();
    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        map.put(0L,0L);
        map.put(1L,1L);
        map.put(2L,1L);

        System.out.println(f(n));
    }

    /**
     * 분할 정복을 활용한 피보나치 계산
     * - f(n) = f(n-1) + f(n-2) = [ f(n-2) + f(n-3) ] + f(n-2) = 2f(n-2) + f(n-3) = f(3)f(n-2) + f(2)f(n-3)
     *        = 3f(n-3) + 2f(n-4) = f(4)f(n-3) + f(3)f(n-4)
     *        = 5f(n-4) + 3f(n-5) = f(5)f(n-4) + f(4)f(n-5)
     *        = f(k+1)f(n-k) + f(k)f(n-(k+1))
     *        = f(n/2+1)f(n/2) + f(n/2)f(n/2-1) (k = n/2)
     *        = f(n/2)[f(n/2+1) + f(n/2-1)]
     *        = f(n/2)[f(n/2) + 2f(n/2-1)]
     *
     * - f(2k) = f(k)^2 + 2f(k)f(k-1) = f(k) * [2f(k-1) + f(k)]
     * - f(2k+1) = f(2(k+1)) - f(2k) (f(n+1) = f(n) + f(n-1) 이용)
     *           = [f(k+1)^2 + 2f(k+1)f(k)] - [f(k)^2 + 2f(k)f(k-1)]
     *           = f(k+1)^2 + 2[f(k)^2 + f(k)f(k-1)] - f(k)^2 - 2f(k)f(k-1)
     *           = f(k+1)^2 + f(k)^2
     */
    private static long f(long n) {
        if (map.containsKey(n)) return map.get(n);

        long result;

        if (n % 2 == 0) {
            // 짝수일 때: f(2k) = f(k) * [2f(k-1) + f(k)]
            long k = n / 2;
            long fk = f(k);
            long fk1 = f(k - 1);
            result = (fk * ((2 * fk1 % MOD + fk) % MOD)) % MOD;
        } else {
            // 홀수일 때: f(2k+1) = f(k+1)^2 + f(k)^2
            long k = n/2;
            long fk = f(k+1);
            long fk1 = f(k);
            result = (fk * fk % MOD + fk1 * fk1 % MOD) % MOD;
        }
        map.put(n, result);
        return result;
    }
}
