package range_sum;

import java.util.*;
import java.io.*;

// 25682
public class Baek_25682 {
    static int n, m, k;
    static int[][] prefix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        prefix = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= m; j++) {
                char current = line.charAt(j - 1);

                char expected = ((i + j) % 2 == 0) ? 'W' : 'B';

                int diff = (current == expected) ? 0 : 1;

                prefix[i][j] = prefix[i - 1][j]
                        + prefix[i][j - 1]
                        - prefix[i - 1][j - 1]
                        + diff;
            }
        }

        int answer = Integer.MAX_VALUE;
        int area = k * k;

        for (int i = k; i <= n; i++) {
            for (int j = k; j <= m; j++) {
                int repaintW = getSum(i - k + 1, j - k + 1, i, j);
                int repaintB = area - repaintW;
                answer = Math.min(answer, Math.min(repaintW, repaintB));
            }
        }

        System.out.println(answer);
    }

    static int getSum(int x1, int y1, int x2, int y2) {
        return prefix[x2][y2]
                - prefix[x1 - 1][y2]
                - prefix[x2][y1 - 1]
                + prefix[x1 - 1][y1 - 1];
    }
}