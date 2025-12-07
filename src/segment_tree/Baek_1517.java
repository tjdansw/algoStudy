package segment_tree;

import java.util.*;
import java.io.*;

// 1517
public class Baek_1517 {
    static int n, m, size=1;
    static long[] segmentTree;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        while (size<n){
            size<<=1;
        }
        size <<= 1;
        segmentTree = new long[size];
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < m; t++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            if(order==0){
                sb.append(subSum(size/2 + Math.min(i, j) -1, size/2 + Math.max(i, j) -1, 0)).append('\n');
            }else{
                long prevValue = segmentTree[size/2+i-1];
                segmentTree[size/2+i-1] = j;
                modifyValue(size/2+i-1, prevValue);
            }
        }
        System.out.println(sb);
    }

    static long subSum(int l, int r, long total){
        if(l>r){
            return total;
        }
        if(l%2==1) total += segmentTree[l];
        if(r%2==0) total += segmentTree[r];
        return subSum((l+1)/2,(r-1)/2, total);
    }

    static void modifyValue(int idx, long prevValue){
        long temp = segmentTree[idx/2];
        segmentTree[idx/2] -= prevValue;
        segmentTree[idx/2] += segmentTree[idx];
        if(idx/2>1) modifyValue(idx/2, temp);
    }
}
