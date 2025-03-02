package implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baek_17219 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n,m;
    static HashMap<String,String> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(),st.nextToken());
        }

        for(int i = 0;i<m;i++){
            sb.append(map.get(br.readLine())).append('\n');
        }
        System.out.println(sb);
    }
}
