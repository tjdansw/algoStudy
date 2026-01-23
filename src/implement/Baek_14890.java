package implement;

import java.util.*;
import java.io.*;

// 14890
public class Baek_14890 {
    static int n, l;
    static int[][] map;

    static boolean checkLine(int[] line) {
        boolean[] used = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            int cur = line[i];
            int next = line[i + 1];
            if (cur == next) continue;

            int diff = next - cur;
            if (Math.abs(diff) != 1) return false;

            if (diff == 1) {
                for (int k = i; k > i - l; k--) {
                    if (k < 0) return false;
                    if (line[k] != cur) return false;
                    if (used[k]) return false;
                }
                for (int k = i; k > i - l; k--) used[k] = true;
            }else {
                for (int k = i + 1; k < i + 1 + l; k++) {
                    if (k >= n) return false;
                    if (line[k] != next) return false;
                    if (used[k]) return false;
                }
                for (int k = i + 1; k < i + 1 + l; k++) used[k] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            int[] line = new int[n];
            for (int j = 0; j < n; j++) line[j] = map[i][j];
            if (checkLine(line)) answer++;
        }

        for (int j = 0; j < n; j++) {
            int[] line = new int[n];
            for (int i = 0; i < n; i++) line[i] = map[i][j];
            if (checkLine(line)) answer++;
        }

        System.out.println(answer);
    }
}
