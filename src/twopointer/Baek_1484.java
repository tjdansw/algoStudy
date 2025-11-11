package twopointer;

import java.io.*;

// 1484
public class Baek_1484 {
    static int g;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        g = Integer.parseInt(br.readLine());
        int currentWeight = 2;
        while (true){
            int minimunTerm = 2*currentWeight - 1;
            if(minimunTerm>g) break;
            for (int i = currentWeight-1; i > 0; i--) {
                int term = currentWeight*currentWeight - i*i;
                if(term == g){
                    sb.append(currentWeight).append('\n');
                }
                if(term>=g){
                    break;
                }
            }
            currentWeight++;
        }

        System.out.println(sb.length()==0?-1:sb.toString());
    }
}
