package implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek_1259 {
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int len;
    static String num;
    static Boolean flag;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));

        while(!(num=br.readLine()).equals("0")) {
            flag = true;
            len = num.length();
            for(int i = 0;i<len/2;i++) {
                if(num.charAt(i)!=num.charAt(len-i-1)) {
                    flag = false;
                    break;
                }
            }
            sb.append(flag?"yes\n":"no\n");
        }

        System.out.println(sb);
    }
}
