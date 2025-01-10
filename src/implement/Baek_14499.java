package implement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_14499 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n, m, k, order, row, col;
    static int[] current = new int[2];
    static int[][] map;
    static int rowI = 1, colI = 1;
    static int[] diceRow = {0,0,0,0}; // 공통 부분 1
    static int[] diceCol = {0,0,0,0}; // 공통 부분 1
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_14499.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        current[0] = Integer.parseInt(st.nextToken());
        current[1] = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            order = Integer.parseInt(st.nextToken());
            row = current[0]+dx[order];
            col = current[1]+dy[order];
            if(!isBound(row, col))  continue;
            diceMove();
            if(map[row][col] == 0) {
                map[row][col] = diceCol[(colI+2)%4];
            }else{
                diceCol[(colI+2)%4] = map[row][col];
                diceRow[(rowI+2)%4] = map[row][col];
                map[row][col] = 0;
            }
            current[0] = row;
            current[1] = col;
            sb.append(diceCol[colI]).append('\n');
        }
        System.out.println(sb);
    }

    static boolean isBound(int x,int y){
        return !(x<0||x>=n||y<0||y>=m);
    }

    static void diceMove(){
        switch(order){
            case 1:{
                if(rowI==0) rowI = 4;
                rowI = (rowI-1)%4;
                diceCol[colI] = diceRow[rowI];
                diceCol[(colI+2)%4] = diceRow[(rowI+2)%4];
                break;
            }
            case 2:{
                rowI = (rowI+1)%4;
                diceCol[colI] = diceRow[rowI];
                diceCol[(colI+2)%4] = diceRow[(rowI+2)%4];
                break;
            }
            case 3:{
                colI = (colI+1)%4;
                diceRow[rowI] = diceCol[colI];
                diceRow[(rowI+2)%4] = diceCol[(colI+2)%4];
                break;
            }
            case 4:{
                if(colI==0) colI = 4;
                colI = (colI-1)%4;
                diceRow[rowI] = diceCol[colI];
                diceRow[(rowI+2)%4] = diceCol[(colI+2)%4];
                break;
            }
        }
    }
}
