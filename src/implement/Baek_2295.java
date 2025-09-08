package implement;

import java.util.*;
import java.io.*;

// 2295
public class Baek_2295 {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int m = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || arr[i] != arr[i - 1]) arr[m++] = arr[i];
        }

        HashSet<Integer> pair = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                pair.add(arr[i] + arr[j]);
            }
        }

        for (int t = m - 1; t >= 0; t--) {
            for (int j = 0; j < m; j++) {
                if (pair.contains(arr[t] - arr[j])) {
                    System.out.println(arr[t]);
                    return;
                }
            }
        }
    }
}
