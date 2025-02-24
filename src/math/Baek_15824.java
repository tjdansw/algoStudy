package math;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baek_15824 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n;
    static long total=0;
    static ArrayList<Long> list = new ArrayList<>();
    static boolean[] checked;
    static long[] power;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_15824.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        checked = new boolean[n+1];
        power = new long[n+1];
        power[0] = 1;
        checked[0] = true;
        for(int i=1;i<=n;i++) power[i] = powerValue(i);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Long.parseLong(st.nextToken()));
        }
        Collections.sort(list);
        for (int i = 0; i < n; i++) {
            long max = (list.get(i) * power[i]) % 1000000007;
            long min = (list.get(i) * power[n - i - 1]) % 1000000007;
            total = (total + max - min + 1000000007) % 1000000007;
        }
        System.out.println(total);
    }

    static long powerValue(int i) {
        if(checked[i]) return power[i];
        long half = powerValue(i/2)%1000000007;
        return i%2==0?((half*half)%1000000007):((half*half*2)%1000000007);
    }
}
