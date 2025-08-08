package dynamic_programming;

import java.util.*;
import java.io.*;

// 1912
public class Baek_1912 {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = Integer.parseInt(st.nextToken());
        int prev = max;
        for (int i = 1; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            prev = Math.max(prev+num, num);
            max = Math.max(max, prev);
        }
        System.out.println(max);
    }
}
