package dynamic_programming;

import java.util.*;
import java.io.*;

// 11057
public class Baek_11057 {
    static final int MOD = 10_007;
    static int n;
    static int[][] increasingNumber;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        increasingNumber = new int[n+1][10];
        Arrays.fill(increasingNumber[1], 1);

        for (int i = 2; i <= n; i++) {
            for (int num = 0; num < 10; num++) {
                for (int prev = 0; prev <= num; prev++) {
                    increasingNumber[i][num] = (increasingNumber[i][num]+increasingNumber[i-1][prev])%MOD;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < 10; i++) {
            answer = (answer+increasingNumber[n][i])%MOD;
        }
        System.out.println(answer);
    }
}
