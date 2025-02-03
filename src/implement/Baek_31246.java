package implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baek_31246 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n, k, abs, cnt=0;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            abs = Integer.parseInt(st.nextToken())-Integer.parseInt(st.nextToken());
            if(abs>=0) cnt++;
            else list.add(-1*abs);
        }
        if(cnt>=k) System.out.println(0);
        else{
            Collections.sort(list);
            System.out.println(list.get(k-cnt-1));
        }
    }
}