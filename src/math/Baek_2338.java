package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Baek_2338 {
    static BufferedReader br;
    static BigInteger a,b;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        a = new BigInteger(br.readLine());
        b = new BigInteger(br.readLine());
        System.out.println(a.add(b));
        System.out.println(a.subtract(b));
        System.out.println(a.multiply(b));

    }
}
