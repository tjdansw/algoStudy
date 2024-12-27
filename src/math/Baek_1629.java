package math;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 주어진 숫자를 거듭제곱한 값을 계속 거듭제곱하여 답을 구함
 */
public class Baek_1629 {
    static StringTokenizer st;
    static BufferedReader br;

    static int a, b, c;
    static long temp, result = 1;
    static String binary;
    
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_1629.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        temp = a;
        binary = Integer.toBinaryString(b);
        for (int i = binary.length()-1; i >=0; i--) {
            System.out.println("곱하는 값 : "+temp);
            if (binary.charAt(i) == '1') {
                result = (result * temp)%c;
            }
            System.out.println("결과값 :" + result);
            temp = (temp * temp)%c;
        }
        System.out.println(result);
    }
}
