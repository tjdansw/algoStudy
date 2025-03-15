package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek_1676 {
    static BufferedReader br;

    static int n, cnt = 0;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        while (n >= 5) {
            cnt += n / 5;
            n /= 5;
        }
        System.out.println(cnt);
    }
}
