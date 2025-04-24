package implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek_7682 {
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while(!(line = br.readLine()).equals("end")){
            check(line);
        }

        System.out.println(sb.toString());
    }

    static int[][] dx ={{0,1,2},{0,1,2}};
    static int[][] dy ={{0,1,2},{2,1,0}};

    public static void check(String line){
        char[][] map = new char[3][3];

        int oCnt = 0;
        int xCnt = 0;
        int dotCnt = 0;

        int oWinCnt = 0;
        int xWinCnt = 0;

        for(int i = 0; i < 9; i++){
            map[i/3][i%3] = line.charAt(i);
            if(map[i/3][i%3] == 'X'){
                xCnt++;
            }else if(map[i/3][i%3] == 'O'){
                oCnt++;
            }else{
                dotCnt++;
            }
        }

        // 행 체크
        for(int i = 0; i < 3; i++){
            char c = map[i][0];
            if(c == '.'){
                continue;
            }
            boolean flag = true;
            for(int j = 1; j < 3&&flag; j++){
                if(map[i][j] != c){
                    flag = false;
                }
            }
            if(flag){
                if(c=='O'){
                    oWinCnt++;
                }else{
                    xWinCnt++;
                }
            }
        }

        // 열 체크
        for(int j = 0; j < 3; j++){
            char c = map[0][j];
            if(c == '.'){
                continue;
            }
            boolean flag = true;
            for(int i = 1; i < 3&&flag; i++){
                if(map[i][j] != c){
                    flag = false;
                }
            }
            if(flag){
                if(c=='O'){
                    oWinCnt++;
                }else{
                    xWinCnt++;
                }
            }
        }

        // 대각선
        for(int i = 0; i<2;i++){
            char c = map[0][dy[i][0]];
            if(c == '.'){continue;}
            boolean flag = true;
            for(int j = 1; j<3&&flag;j++){
                if(c!=map[dx[i][j]][dy[i][j]]){
                    flag = false;
                }
            }
            if(flag){
                if(c=='O'){
                    oWinCnt++;
                }else{
                    xWinCnt++;
                }
            }
        }

        if(oWinCnt + xWinCnt==0){
            sb.append((xCnt-oCnt==1&&dotCnt==0)?"valid\n":"invalid\n");
        }else if(oWinCnt + xWinCnt==1){
            if(oWinCnt==1){
                sb.append(xCnt-oCnt==0?"valid\n":"invalid\n");
            }else{
                sb.append(xCnt-oCnt==1?"valid\n":"invalid\n");
            }
        }else if(oWinCnt + xWinCnt==2){
            if(oWinCnt==2){
                boolean flag = xCnt-oCnt==0&&oCnt==5;
                sb.append(flag?"valid\n":"invalid\n");
            }else if(xWinCnt==2){
                boolean flag = xCnt-oCnt==1&&xCnt==5;
                sb.append(flag?"valid\n":"invalid\n");
            }else{
                sb.append("invalid\n");
            }
        }else{
            sb.append("invalid\n");
        }
    }
}
