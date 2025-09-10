package brute_force;

import java.util.*;
import java.io.*;

// 8973
public class Baek_8973 {
    static int n;
    static int[] arrA, arrB;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arrA = new int[n];
        arrB = new int[n];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0;i<n;i++){
            arrA[i] = Integer.parseInt(st1.nextToken());
            arrB[i] = Integer.parseInt(st2.nextToken());
        }

        int b = 0, e = 0;
        int max = -1_000_000;

        for(int nB = 0; nB<n; nB++){
            for(int nE = 0; nE<n;nE++){
                int size = n - (nB+nE);
                if(size>n || size == 0) break;
                int sI = nB;
                int sJ = n-1-nE;
                int total = 0;
                for(int i = 0;i<size;i++){
                    total += arrA[sI+i]*arrB[sJ-i];
                }
                if(total>max){
                    b = nB;
                    e = nE;
                    max = total;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(b).append(' ').append(e).append('\n').append(max);
        System.out.println(sb);
    }
}
