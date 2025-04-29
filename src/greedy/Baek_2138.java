package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_2138 {
    static int n;
    static boolean[] now, target;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        now = new boolean[n];
        target = new boolean[n];

        String line = br.readLine();
        for (int i = 0; i < n; i++) {
            now[i] = line.charAt(i) == '1';
        }

        line = br.readLine();
        for (int i = 0; i < n; i++) {
            target[i] = line.charAt(i) == '1';
        }

        int result = Integer.MAX_VALUE;

        result = Math.min(result, solve(Arrays.copyOf(now, n), false));
        result = Math.min(result, solve(Arrays.copyOf(now, n), true));

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    public static int solve(boolean[] arr, boolean firstSwitch) {
        int cnt = 0;

        if (firstSwitch) {
            press(arr, 0);
            cnt++;
        }

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] != target[i - 1]) {
                press(arr, i);
                cnt++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] != target[i]) return Integer.MAX_VALUE;
        }

        return cnt;
    }

    public static void press(boolean[] arr, int idx) {
        for (int i = idx - 1; i <= idx + 1; i++) {
            if (i >= 0 && i < n) {
                arr[i] = !arr[i];
            }
        }
    }
}
