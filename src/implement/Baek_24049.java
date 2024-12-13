package implement;

import java.io.*;
import java.util.*;

public class Baek_24049 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n, m;
    static int[][] row;
    static int[] col;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_24049.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        row = new int[2][m + 1];
        col = new int[n + 1];

        // col 배열 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            col[i] = Integer.parseInt(st.nextToken());
        }

        // row 배열 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            row[0][i] = Integer.parseInt(st.nextToken());
        }

        // 비트 연산으로 연산 수행
        for (int i = 1; i <= n; i++) {
            row[i % 2][1] = (row[(i + 1) % 2][1] ^ col[i]) & 1; // XOR 연산
            for (int j = 2; j <= m; j++) {
                row[i % 2][j] = (row[(i + 1) % 2][j] ^ row[i % 2][j - 1]) & 1; // XOR 연산
            }
        }

        // 결과 출력
        System.out.println(row[n % 2][m]);
    }
}
