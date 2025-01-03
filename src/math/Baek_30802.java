package math;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_30802 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n, t, p, total=0;
    static int[] peopleNum = new int[6];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_30802.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            peopleNum[i] = Integer.parseInt(st.nextToken());
            total += peopleNum[i];
        }
        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        int tshirt = 0;
        for (int i = 0; i < 6; i++) {
            tshirt += peopleNum[i]/t+(peopleNum[i]%t>0?1:0);
        }
        sb.append(tshirt).append("\n");
        sb.append(total/p).append(" ").append(total%p);
        System.out.println(sb);
    }
}
