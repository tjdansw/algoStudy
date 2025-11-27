package coding_test;

import java.util.*;
import java.io.*;

// 2025.11.16
public class HyundaiAutiever {
    static int n;
    static long[] alphabet = new long[26];
    static char[][] words;
    static int[] wordLen = new int[2];

    public String solve(String[][] querys, String t){
        n = t.length();
        words = new char[2][2*n];
        for (int i = 0; i < n; i++) {
            char c = t.charAt(i);
            words[0][i] = c;
            int idx = (int)(c-'A');
            alphabet[idx]++;
        }
        wordLen[0] = n;

        for (int i = 0; i < querys.length; i++) {
            char c = querys[i][0].charAt(0);
            int idx = (int)(c-'A');
            long cnt = alphabet[idx];
            alphabet[idx] = 0;
            for (int j = 0; j < querys[i][1].length(); j++) {
                char p = querys[i][1].charAt(j);
                int temp = (int)(p-'A');
                alphabet[temp] += cnt;
            }
            int start = 0;
            for (int j = 0; j < wordLen[i%2]&&start<2*n; j++) {
                if(words[i%2][j]==c){
                    for (int k = 0; k < querys[i][1].length()&&start<2*n; k++) {
                        words[(i+1)%2][start++] = querys[i][1].charAt(k);
                    }
                }else{
                    words[(i+1)%2][start++] = words[i%2][j];
                }
            }
            wordLen[(i+1)%2] = start;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wordLen[querys.length%2]; i++) {
            sb.append(words[querys.length%2][i]);
        }
        long total = 0;
        for (int i = 0; i < 26; i++) {
            total+=alphabet[i];
        }
        total -= wordLen[querys.length%2];
        if(total>0){
            sb.append('+').append(total);
        }
        return sb.toString();
    }


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String start = br.readLine();
        int t = Integer.parseInt(br.readLine());
        String[][] querys = new String[t][2];
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            querys[i][0] = st.nextToken();
            querys[i][1] = st.nextToken();
        }
        HyundaiAutiever m = new HyundaiAutiever();
        System.out.println(m.solve(querys, start));
    }
}
