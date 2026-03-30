package binary_search;

import java.util.*;
import java.io.*;

// 14003
public class Baek_14003 {
    static int n;
    static int[] arr;
    static int[] lis;
    static int[] prev;
    static int[] idxAtLen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        lis = new int[n];
        prev = new int[n];
        idxAtLen = new int[n];
        int len = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            int l = 0, r = len;
            while (l < r) {
                int mid = (l + r) / 2;
                if (lis[mid] < arr[i]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            lis[l] = arr[i];

            if (l > 0) prev[i] = idxAtLen[l - 1];
            else prev[i] = -1;

            idxAtLen[l] = i;

            if (l == len) len++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(len).append('\n');

        int[] answer = new int[len];
        int cur = idxAtLen[len - 1];

        for (int i = len - 1; i >= 0; i--) {
            answer[i] = arr[cur];
            cur = prev[cur];
        }

        for (int i = 0; i < len; i++) {
            sb.append(answer[i]).append(' ');
        }
        System.out.println(sb);

    }
}
