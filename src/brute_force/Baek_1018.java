package brute_force;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1018 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n,m,min=Integer.MAX_VALUE;
    static String[] line;
    static char[][] patterns = {
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'}
    };

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_1018.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        line = new String[n];
        for (int i = 0; i < n; i++) {
            line[i] = br.readLine();
        }
        for(int i = 0; i < n-7; i++){
            for(int j = 0; j < m-7; j++){
                check(i,j);
            }
        }
        System.out.println(min);
    }

    static void check(int x, int y){
        int[] sum = new int[2];
        int a = 0;
        int b = 1;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                int row = x+i;
                int col = y+j;
                if(line[row].charAt(col) != patterns[a][j]) sum[0]++;
                if(line[row].charAt(col) != patterns[b][j]) sum[1]++;
            }
            a = (a+1)%2;
            b = (b+1)%2;
        }
        min = Math.min(min,sum[0]);
        min = Math.min(min,sum[1]);
    }
}
