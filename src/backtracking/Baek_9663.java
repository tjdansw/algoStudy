package backtracking;

import java.io.*;

public class Baek_9663 {
    static int n, cnt = 0;
    static final int SIZE = 30;
    static boolean[] colCheck = new boolean[SIZE];
    static boolean[] plusCrossCheck = new boolean[SIZE];
    static boolean[] minusCrossCheck = new boolean[SIZE];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dfs(0);
        System.out.println(cnt);
    }

    private static void dfs(int row) {
        if (row == n) {
            cnt++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (colCheck[col]
                    || plusCrossCheck[row + col]
                    || minusCrossCheck[row - col + n]) {
                continue;
            }

            colCheck[col] = true;
            plusCrossCheck[row + col] = true;
            minusCrossCheck[row - col + n] = true;

            dfs(row + 1);

            colCheck[col] = false;
            plusCrossCheck[row + col] = false;
            minusCrossCheck[row - col + n] = false;
        }
    }
}
