package twopointer;

import java.util.*;
import java.io.*;

// 30804
public class Baek_30804 {
    static int n;
    static int[] fruits;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        fruits = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[10];
        int kind = 0;
        int l = 0, maxLen = 0;

        for (int r = 0; r < n; r++) {
            if (count[fruits[r]] == 0) kind++;
            count[fruits[r]]++;
            while (kind > 2) {
                count[fruits[l]]--;
                if (count[fruits[l]] == 0) kind--;
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }
        System.out.println(maxLen);
    }
}
