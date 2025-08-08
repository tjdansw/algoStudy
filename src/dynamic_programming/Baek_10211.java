package dynamic_programming;

import java.util.*;
import java.io.*;

// 10211
public class Baek_10211 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int tc = 0;tc<t;tc++){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int totalMax = Integer.parseInt(st.nextToken());
            int currentMax = totalMax;
            for(int i = 1; i < n; i++){
                int num = Integer.parseInt(st.nextToken());
                currentMax = Math.max(currentMax+num, num);
                totalMax = Math.max(totalMax, currentMax);
            }
            sb.append(totalMax).append("\n");
        }
        System.out.println(sb);
    }
}
