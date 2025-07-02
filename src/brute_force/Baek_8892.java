package brute_force;

import java.io.*;

//
public class Baek_8892 {
    static String[] word;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int k;

        for (int tc = 0; tc < t; tc++) {
            k = Integer.parseInt(br.readLine());
            word = new String[k];
            for (int i = 0; i < k; i++) {
                word[i] = br.readLine();
            }
            boolean flag = false;
            for (int i = 0; i < k && (!flag); i++) {
                for (int j = 0; j < k && (!flag); j++) {
                    if(i==j) continue;
                    String res = isPalindrome(i,j);
                    if(res != null){
                        sb.append(res).append("\n");
                        flag = true;
                    }
                }
            }
            if(!flag){
                sb.append("0\n");
            }
        }

        System.out.println(sb);
    }

    private static String isPalindrome(int x, int y) {
        String str = word[x].concat(word[y]);
        int size = str.length();
        for(int i = 0; i < size/2; i++){
            if(str.charAt(i) != str.charAt(size-1-i)){
                return null;
            }
        }
        return str;
    }
}
