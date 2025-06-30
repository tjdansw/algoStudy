package implement;

import java.io.*;

// 5525
public class Baek_5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int count = 0;
        int result = 0;

        for (int i = 1; i < m - 1; ) {
            if (s.charAt(i - 1) == 'I' && s.charAt(i) == 'O' && s.charAt(i + 1) == 'I') {
                count++;
                i += 2;
                if (count == n) {
                    result++;
                    count--;
                }
            } else {
                i++;
                count = 0;
            }
        }

        System.out.println(result);
    }
}