package bitoperator;

import java.util.*;
import java.io.*;

// 13701
public class Baek_13701 {
    static BitSet bitset = new BitSet(1<<25);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()){
            int x = Integer.parseInt(st.nextToken());
            if(!bitset.get(x)){
                bitset.set(x);
                sb.append(x).append(' ');
            }
        }

        System.out.println(sb);
    }
}
