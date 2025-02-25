package math;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_5086 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int a, b;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_5086.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if(a == 0 && b == 0) break;
            if(a<b&&b%a==0) sb.append("factor\n");
            else if(a>b&&a%b==0) sb.append("multiple\n");
            else sb.append("neither\n");
        }
        System.out.println(sb);
    }
}
