package math;

import java.util.*;
import java.io.*;

// 1850
public class Baek_1850 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        if (a < b) {
            long temp = a;
            a = b;
            b = temp;
        }
        long gcd = gcd(a, b);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < gcd; i++) {
            sb.append(1);
        }
        System.out.println(sb);
    }

    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
