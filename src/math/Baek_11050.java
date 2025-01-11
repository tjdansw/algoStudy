package math;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_11050 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n,k;
    static long result=1;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_11050.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        k = Math.min(n-k,k);

        for(int i=0;i<k;i++) result*=n--;

        for(int i=1;i<=k;i++) result/=i;

        System.out.println(result);
    }
}
