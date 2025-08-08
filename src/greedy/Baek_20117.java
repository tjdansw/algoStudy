package greedy;

import java.util.*;
import java.io.*;

// 20117
public class Baek_20117 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int sum = (n%2==1?arr[n/2]:0);
        for (int i = n-1; i >= (n+1)/2; i--) {
            sum += arr[i]*2;
        }
        System.out.println(sum);
    }
}
