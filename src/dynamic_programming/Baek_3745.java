package dynamic_programming;

import java.util.*;
import java.io.*;

// 3745
public class Baek_3745 {
    static int n, len;
    static int[] lis = new int[100_000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine())!=null){
            n = Integer.parseInt(line.trim());
            len = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                int x = Integer.parseInt(st.nextToken());
                int left = 0, right = len;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (lis[mid] >= x) right = mid;
                    else left = mid + 1;
                }

                lis[left] = x;
                if (left == len) len++;
            }
            sb.append(len).append('\n');
        }
        System.out.println(sb);
    }
}
