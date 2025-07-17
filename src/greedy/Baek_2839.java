package greedy;

import java.io.*;

// 2839
public class Baek_2839 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int fiveBag = 0, threeBag = 0;

        int value;
        while(threeBag*3<=n){
            value = n-threeBag*3;
            if(value % 5 == 0){
                fiveBag = value / 5;
                break;
            }
            threeBag++;
        }
        int res = threeBag*3>n?-1:fiveBag+threeBag;
        System.out.println(res);
    }
}
