package math;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1978 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n, cnt=0;
    static boolean[] primeNums = new boolean[1001];

    static {
        primeNums[2] = true;
        for(int i =3; i<1001; i+=2){
            primeNums[i] = true;
            for(int j = 3;j<i/2;j+=2){
                if(i%j==0){
                    primeNums[i] = false;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_1978.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            cnt+= primeNums[Integer.parseInt(st.nextToken())]?1:0;
        }

        System.out.println(cnt);
    }
}
