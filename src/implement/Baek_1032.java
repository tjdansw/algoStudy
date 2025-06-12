package implement;

import java.io.*;

public class Baek_1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] list = new String[n];
        for (int i = 0; i < n; i++) {
            list[i] = br.readLine();
        }
        for (int i = 0; i < list[0].length(); i++) {
            boolean flag = true;
            for (int j = 1; j < n&&flag; j++) {
                if(list[j].charAt(i) != list[j-1].charAt(i)) {
                    flag = false;
                }
            }
            sb.append(flag?list[0].charAt(i):'?');
        }
        System.out.println(sb);
    }
}
