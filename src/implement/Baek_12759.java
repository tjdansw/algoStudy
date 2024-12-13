package implement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_12759 {
    static StringTokenizer st;
    static BufferedReader br;

    static int player,winner;
    static boolean[][][] check = new boolean[2][4][4];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_12759.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));

        player = Integer.parseInt(br.readLine())-1;
        winner = 0;

        for(int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            check[(player+i)%2][x][y] = true;
            if(i>4){
                winner = playerWin(0)?1:0;
                if(winner != 0){
                    break;
                }
                winner = playerWin(1)?2:0;
                if(winner != 0){
                    break;
                }
            }
        }
        System.out.println(winner);
    }

    static boolean playerWin(int player) {
        boolean flag = false;
        flag = flag||(check[player][1][1]&&check[player][1][2]&&check[player][1][3]);
        flag = flag||(check[player][2][1]&&check[player][2][2]&&check[player][2][3]);
        flag = flag||(check[player][3][1]&&check[player][3][2]&&check[player][3][3]);
        flag = flag||(check[player][1][1]&&check[player][2][1]&&check[player][3][1]);
        flag = flag||(check[player][1][2]&&check[player][2][2]&&check[player][3][2]);
        flag = flag||(check[player][1][3]&&check[player][2][3]&&check[player][3][3]);
        flag = flag||(check[player][1][1]&&check[player][2][2]&&check[player][3][3]);
        flag = flag||(check[player][3][1]&&check[player][2][2]&&check[player][1][3]);
        return flag;
    }
}
