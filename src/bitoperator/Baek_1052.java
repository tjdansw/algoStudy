package bitoperator;

import java.util.*;
import java.io.*;

// 1052
public class Baek_1052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (k >= Integer.bitCount(n)) {
            System.out.println(0);
            return;
        }

        int answer = 0;

        while (Integer.bitCount(n) > k) {
            n++;
            answer++;
        }

        System.out.println(answer);
    }
}