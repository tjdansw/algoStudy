package greedy;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

// 1036
public class Baek_1036 {
    static int n, k;
    static String[] numbers;
    static int[] value = new int[128];

    static {
        for (int i = 0; i < 10; i++) value['0' + i] = i;
        for (int i = 0; i < 26; i++) value['A' + i] = i + 10;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        numbers = new String[n];

        BigInteger total = BigInteger.ZERO;
        BigInteger[] gain = new BigInteger[36];
        Arrays.fill(gain, BigInteger.ZERO);

        BigInteger[] pow36 = new BigInteger[51];
        pow36[0] = BigInteger.ONE;
        for (int i = 1; i <= 50; i++) {
            pow36[i] = pow36[i - 1].multiply(BigInteger.valueOf(36));
        }

        for (int i = 0; i < n; i++) {
            String s = br.readLine().trim();
            numbers[i] = s;

            int len = s.length();
            for (int j = 0; j < len; j++) {
                char c = s.charAt(len - 1 - j);
                int v = value[c];

                total = total.add(pow36[j].multiply(BigInteger.valueOf(v)));

                BigInteger diff = pow36[j].multiply(BigInteger.valueOf(35 - v));
                gain[v] = gain[v].add(diff);
            }
        }

        k = Integer.parseInt(br.readLine());

        Arrays.sort(gain, Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            total = total.add(gain[i]);
        }

        if (total.equals(BigInteger.ZERO)) {
            System.out.println("0");
        } else {
            System.out.println(total.toString(36).toUpperCase());
        }
    }
}