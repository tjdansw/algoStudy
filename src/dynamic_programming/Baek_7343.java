package dynamic_programming;

import java.io.*;
import java.util.*;

// 7343
public class Baek_7343 {
    static final int SY = 1900, SM = 1, SD = 1;
    static final int TY = 2001, TM = 11, TD = 4;
    static final int[] MD = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int targetIdx = idx(TY, TM, TD);

        boolean[] win = new boolean[targetIdx + 1];
        win[targetIdx] = false;

        for (int i = targetIdx - 1; i >= 0; i--) {
            boolean canWin = false;

            int nextDay = i + 1;
            if (nextDay <= targetIdx && !win[nextDay]) canWin = true;

            if (!canWin) {
                int[] ymd = ymd(i);
                int[] nm = nextMonth(ymd[0], ymd[1], ymd[2]);
                if (nm != null) {
                    int j = idx(nm[0], nm[1], nm[2]);
                    if (j <= targetIdx && !win[j]) canWin = true;
                }
            }
            win[i] = canWin;
        }

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if (!isValid(y, m, d)) {
                sb.append("NO\n");
                continue;
            }
            int s = idx(y, m, d);
            if (s > targetIdx) {
                sb.append("NO\n");
                continue;
            }

            sb.append(win[s] ? "YES\n" : "NO\n");
        }
        System.out.print(sb);
    }

    static boolean isLeap(int y) {
        return (y % 4 == 0) && (y % 100 != 0 || y % 400 == 0);
    }

    static boolean isValid(int y, int m, int d) {
        if (m < 1 || m > 12) return false;
        int md = MD[m] + ((m == 2 && isLeap(y)) ? 1 : 0);
        return d >= 1 && d <= md;
    }

    static int idx(int y, int m, int d) {
        int days = 0;
        for (int yy = SY; yy < y; yy++) days += 365 + (isLeap(yy) ? 1 : 0);
        for (int mm = 1; mm < m; mm++) {
            days += MD[mm];
            if (mm == 2 && isLeap(y)) days++;
        }
        return days + (d - 1);
    }

    static int[] ymd(int index) {
        int y = SY, rem = index;

        while (true) {
            int ydays = 365 + (isLeap(y) ? 1 : 0);
            if (rem >= ydays) {
                rem -= ydays;
                y++;
            } else break;
        }
        int m = 1;
        while (true) {
            int md = MD[m] + ((m == 2 && isLeap(y)) ? 1 : 0);
            if (rem >= md) {
                rem -= md;
                m++;
            } else break;
        }
        int d = rem + 1;
        return new int[]{y, m, d};
    }

    static int[] nextMonth(int y, int m, int d) {
        int ny = y + ((m + 1) > 12 ? 1 : 0);
        int nm = (m + 1) > 12 ? 1 : (m + 1);
        if (!isValid(ny, nm, d)) return null;
        return new int[]{ny, nm, d};
    }
}
