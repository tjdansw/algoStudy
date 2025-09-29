package graph;

import java.util.*;
import java.io.*;

// 6593
public class Baek_6593 {
    static int l, r, c;
    static char[][][] block;
    static int[] dx ={ 1, 0, -1 , 0 ,0 , 0};
    static int[] dy ={ 0, -1 , 0 ,1 , 0, 0};
    static int[] dz ={ 0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(l==0&&r==0&&c==0) break;
            block = new char[l][r][c];
            int sx = 0, sy = 0, sz = 0;
            for (int h = 0; h < l; h++) {
                for (int i = 0; i < r; i++) {
                    String line = br.readLine();
                    for (int j = 0; j < c; j++) {
                        block[h][i][j] = line.charAt(j);
                        if(block[h][i][j] == 'S'){
                            sx = i;
                            sy = j;
                            sz = h;
                        }
                    }
                }
                br.readLine();
            }

            int min = 0;
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{sx, sy, sz, 0});
            boolean[][][] visited = new boolean[l][r][c];
            visited[sz][sx][sy] = true;

            while (!q.isEmpty()&&min==0){
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                int z = cur[2];
                int time = cur[3];

                for (int i = 0; i < 6; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    int nz = z + dz[i];
                    if(isBound(nx, ny, nz)&&!visited[nz][nx][ny]&&block[nz][nx][ny]!='#'){
                        if(block[nz][nx][ny]=='E'){
                            min = time+1;
                            break;
                        }
                        visited[nz][nx][ny] = true;
                        q.add(new int[]{nx, ny, nz, time+1});
                    }
                }
            }


            if(min == 0){
                sb.append("Trapped!\n");
            }else{
                sb.append("Escaped in ").append(min).append(" minute(s).\n");
            }
        }

        System.out.println(sb);
    }

    static boolean isBound(int x, int y, int z){
        return z>=0&&z<l&&x>=0&&x<r&&y>=0&&y<c;
    }
}
