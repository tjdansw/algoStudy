package math;

import java.io.*;
import java.util.*;

public class Baek_2143 {
    static int[] a, b;
    static int t, n, m;
    static HashMap<Integer,Integer> setA = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        a = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i+1] = a[i] + Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        b = new int[m+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            b[i+1] = b[i] + Integer.parseInt(st.nextToken());
        }

        for(int i = n;i>0;i--) {
            for(int j = i-1;j>=0;j--) {
                int value = a[i] - a[j];
                setA.put(value, setA.getOrDefault(value,0)+1);
            }
        }

        long cnt = 0;
        for(int i = m;i>0;i--) {
            for(int j = i-1;j>=0;j--) {
                int value = t - (b[i] - b[j]);
                cnt += setA.getOrDefault(value,0);
            }
        }

        System.out.println(cnt);
    }
}
