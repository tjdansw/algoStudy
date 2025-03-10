package segment_tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_11505 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static final long MOD = 1_000_000_007;
    static int n, m, k, size;
    static long[] tree;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        size = (int)Math.pow(2,(int)Math.ceil(Math.log(n)/Math.log(2))+1);

        tree = new long[size];
        Arrays.fill(tree, 1);
        for(int i = 0;i<n;i++) tree[i+size/2] = Long.parseLong(br.readLine());
        for(int i = size/2+n-1;i>1;i--) tree[i/2] = (tree[i/2]*tree[i])%MOD;

        for(int i = 0;i<m+k;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a==1){
                int b = Integer.parseInt(st.nextToken())+size/2-1;
                tree[b] = Long.parseLong(st.nextToken());
                while (b > 1) {
                    b /= 2;
                    tree[b] = (tree[b * 2] * tree[b * 2 + 1]) % MOD;
                }
            }else{
                int b = Integer.parseInt(st.nextToken())+size/2-1;
                int c = Integer.parseInt(st.nextToken())+size/2-1;
                long total = 1;
                while(b<=c){
                    if(b%2==1) total = (total*tree[b])%MOD;
                    if(c%2==0) total = (total*tree[c])%MOD;
                    if (total==0) break;
                    b = (b+1)/2;
                    c = (c-1)/2;
                }
                sb.append(total).append("\n");
            }
        }

        System.out.println(sb);
    }
}
