package twopointer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_7453 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n;
    static long cnt = 0;
    static int[][] arr;
    static long[] a, b;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_7453.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[4][n];
        a = new long[n * n];
        b = new long[n * n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[idx] = arr[0][i] + arr[1][j];
                b[idx++] = arr[2][i] + arr[3][j];
            }
        }
        Arrays.sort(a);
        Arrays.sort(b);

        int left = 0, right = idx - 1;
        while (left < idx && right >= 0) {
            if (a[left] + b[right] == 0) {
                int temp = left;
                long leftCnt = 0;
                long rightCnt = 0;
                while(left < idx&&a[left] + b[right] == 0){
                    leftCnt++;
                    left++;
                }
                while(right >= 0&&a[temp] + b[right] == 0){
                    rightCnt++;
                    right--;
                }
                cnt+=leftCnt*rightCnt;
            } else if (a[left] + b[right] > 0) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(cnt);
    }
}
