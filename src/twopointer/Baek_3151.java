package twopointer;

import java.util.*;
import java.io.*;

// 3151
public class Baek_3151 {
    static int[] codingScores;
    static boolean[] isUsed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        codingScores = new int[n];
        isUsed = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            codingScores[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(codingScores);

        long res = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int target = -(codingScores[i] + codingScores[j]);
                res += upper(j+1,n-1,target)-lower(j+1,n-1,target);
            }
        }
        System.out.println(res);
    }

    static int lower(int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;

            if (codingScores[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    static int upper(int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;

            if (codingScores[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
