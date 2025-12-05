package segment_tree;

import java.util.*;
import java.io.*;

// 1275
public class Baek_1275 {
    static int n, q, size=1;
    static long[] segmentTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        while (size < n) {
            size <<= 1;
        }
        size <<= 1;
        segmentTree = new long[size];
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++){
            segmentTree[size/2+i] = Integer.parseInt(st.nextToken());
        }
        for (int i = size/2-1; i > 0; i--) {
            segmentTree[i] = segmentTree[2*i]+segmentTree[2*i+1];
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(findSubSum(0, size/2 + Math.min(x, y) - 1, size/2 + Math.max(x, y) - 1)).append('\n');
            long prevValue = segmentTree[size/2+a-1];
            segmentTree[size/2+a-1] = b;
            changeValue(size/2+a-1, prevValue);
        }
        System.out.println(sb);
    }

    static long findSubSum(long total, int l, int r){
        if(r<l){
            return total;
        }
        if(l%2==1) total += segmentTree[l];
        if(r%2==0) total += segmentTree[r];
        return findSubSum(total,(l+1)/2,(r-1)/2);
    }

    static void changeValue(int idx, long prevValue) {
        long temp = segmentTree[idx/2];
        segmentTree[idx/2] -= prevValue;
        segmentTree[idx/2] += segmentTree[idx];
        if(idx/2>1) changeValue(idx/2, temp);
    }

}