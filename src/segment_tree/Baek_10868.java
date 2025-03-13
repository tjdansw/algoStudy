package segment_tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_10868 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n, m, size;
    static int[] tree;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        size = (int) Math.pow(2, Math.ceil(Math.log(n) / Math.log(2))+1);
        tree = new int[size];

        for(int i = 0; i < n; i++) {
            tree[size/2+i] = Integer.parseInt(br.readLine());
        }
        int start = size/2 + n - 1;
        if(n%2==1){
            start++;
            tree[start] = Integer.MAX_VALUE;
        }
        for(int i = start; i > 1; i-=2) {
            tree[i/2] = Math.min(tree[i-1], tree[i]);
        }

        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())+size/2 - 1;
            int b = Integer.parseInt(st.nextToken())+size/2 - 1;
            int min = Integer.MAX_VALUE;
            while(a<=b){
                if(a%2==1) min = Math.min(min, tree[a]);
                if(b%2==0) min = Math.min(min, tree[b]);
                a = (a+1)/2;
                b = (b-1)/2;
            }
            sb.append(min).append("\n");
        }
        System.out.println(sb);
    }
}
