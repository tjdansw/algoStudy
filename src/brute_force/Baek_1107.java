package brute_force;

import java.io.*;
import java.util.*;

// 1107
public class Baek_1107 {
    static int n, m;
    static boolean[] isBroken = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        if(m != 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int num = Integer.parseInt(st.nextToken());
                isBroken[num] = true;
            }
        }
        int min = Math.abs(n-100);
        for (int ch = 0; ch <= 1_000_000; ch++) {
            int len = pressLen(ch);
            if (len > 0) {
                int cost = len + Math.abs(n - ch);
                min = Math.min(min, cost);
            }
        }

        System.out.println(min);
    }

    static int pressLen(int num) {
        if (num == 0) {
            return isBroken[0] ? 0 : 1;
        }
        int len = 0;
        while (num > 0) {
            int d = num % 10;
            if (isBroken[d]) return 0;
            len++;
            num /= 10;
        }
        return len;
    }
}
