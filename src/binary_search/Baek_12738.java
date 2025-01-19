package binary_search;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_12738 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n, left, right, idx=1;
    static int[] a;
    static int[] result;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_12738.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        result = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
        result[0] = -1000000001;
        for(int i = 0;i<n;i++){
            left = 1;
            right = idx-1;
            if(result[right]<a[i]){
                result[idx++] = a [i];
                continue;
            }
            while(left<right){
                int mid = (left+right)/2;
                if(result[mid]<a[i])left = mid+1;
                else right = mid;
            }
            result[right] = a[i];
        }

        System.out.println(idx-1);
    }
}
