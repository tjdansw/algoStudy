package implement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_10816 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n, value;
    static int[][] card = new int[2][10000001];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_10816.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            value = Integer.parseInt(st.nextToken());
            if(value < 0) card[0][value*-1]++;
            else card[1][value]++;
        }
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            value = Integer.parseInt(st.nextToken());
            if(value < 0) sb.append(card[0][value*-1]).append(' ');
            else sb.append(card[1][value]).append(' ');
        }
        System.out.println(sb);
    }
}
