package dynamic_programming;

import java.io.*;

// 26156
public class Baek_26156 {
    static final int MOD = 1_000_000_007;
    static int n;
    static String word;
    static long[] pow = new long[1_000_001];
    static long r = 0, o = 0, c = 0, k = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        word = br.readLine();

        pow[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow[i] = (pow[i-1]*2)%MOD;
        }

        long answer = 0;
        for(int i = 0;i<n;i++){
            char ch = word.charAt(i);
            if(ch=='R'){
                r = (r+pow[i])%MOD;
            }else if(ch=='O'){
                o = (o+r)%MOD;
            }else if(ch=='C'){
                c = (c+o)%MOD;
            }else if(ch=='K'){
                k = (k+c)%MOD;
            }
        }
        System.out.println(k%MOD);
    }
}
