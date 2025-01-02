package implement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Baek_4999 {
    static BufferedReader br;

    static int current, target;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_4999.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        current = br.readLine().length();
        target = br.readLine().length();
        System.out.println(current>=target?"go":"no");
    }
}
