package segment_tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2042 {
    static StringBuilder sb=new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br;

    static int n, m, k, exp, size;
    static long[] tree;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        exp = (int)Math.ceil(Math.log(n)/Math.log(2));
        size = (int)Math.pow(2, exp+1);
        tree = new long[size];
        for(int i = 0; i < n; i++) {
            tree[size/2+i] = Long.parseLong(br.readLine());
        }
        for(int i = size/2+n-1; i > 1 ; i--) {
            tree[i/2] += tree[i];
        }

        for(int i = 0; i < m+k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken())-1;
            String c = st.nextToken();
            if(a==1){
                long temp = tree[size/2+b];
                tree[size/2+b] = Long.parseLong(c);
                changeValue(size/2+b,temp);
            }else{
                findSubsum(0,size/2+b,size/2+Integer.parseInt(c)-1);
            }
        }
        System.out.println(sb);
    }

    static void changeValue(int idx, long val) {
        long temp = tree[idx/2];
        tree[idx/2] -= val;
        tree[idx/2] += tree[idx];
        if(idx/2>1) changeValue(idx/2, temp);
    }

    static void findSubsum(long total, int l,int r) {
        if(r<l){
            sb.append(total).append("\n");
            return;
        }
        if(l%2==1) total += tree[l];
        if(r%2==0) total += tree[r];
        findSubsum(total,(l+1)/2,(r-1)/2);
    }
}
