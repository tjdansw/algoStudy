package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_9375 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int t,n, total, cnt;
    static String category;
    static HashSet<String> categorys = new HashSet<>();
    static HashMap<String, Integer> products = new HashMap<>();

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for(int tc = 0;tc<t;tc++) {
            n = Integer.parseInt(br.readLine());
            total = 1;
            for(int i=0;i<n;i++) {
                st = new StringTokenizer(br.readLine());
                category = st.nextToken();
                category = st.nextToken();
                categorys.add(category);
                cnt = products.getOrDefault(category, 1);
                cnt++;
                products.put(category, cnt);
            }
            for(String category : categorys) {
                total *= products.get(category);
            }
            sb.append(total-1).append('\n');
            categorys.clear();
            products.clear();
        }

        System.out.println(sb);
    }
}
