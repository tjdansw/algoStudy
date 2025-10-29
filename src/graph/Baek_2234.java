package graph;

import java.util.*;
import java.io.*;

// 2234
public class Baek_2234 {
    static int n, m;
    static int[][] map, typeRoom;
    static int[] direction = {1, 2, 4, 8};
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int totalRoomCnt = 0, maxRoomSize = 0, maxTwoRoomSize = 0;
    static HashMap<Integer, Integer> roomSizeOfIdx = new HashMap<>();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        typeRoom = new int[n][m];
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(typeRoom[i][j]!=0) continue;
                totalRoomCnt++;
                int size = 1;
                q.add(new int[]{i,j});
                typeRoom[i][j] = totalRoomCnt;
                while (!q.isEmpty()){
                    int[] cur = q.poll();
                    int x = cur[0];
                    int y = cur[1];
                    for (int k = 0; k < 4; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if(canMove(x, y, k)&&(typeRoom[nx][ny]==0)){
                            typeRoom[nx][ny] = totalRoomCnt;
                            size++;
                            q.add(new int[]{nx, ny});
                        }
                    }
                }
                maxRoomSize = Math.max(maxRoomSize, size);
                roomSizeOfIdx.put(totalRoomCnt, size);
            }
        }

        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visited[i][j]) continue;
                int idx = typeRoom[i][j];
                q.add(new int[]{i,j});
                visited[i][j] = true;
                while (!q.isEmpty()){
                    int[] cur = q.poll();
                    int x = cur[0];
                    int y = cur[1];
                    for (int k = 0; k < 4; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if(isBound(nx, ny)){
                            int roomType = typeRoom[nx][ny];
                            if(roomType!=idx){
                                maxTwoRoomSize = Math.max(maxTwoRoomSize, roomSizeOfIdx.get(idx)+roomSizeOfIdx.get(roomType));
                            }else if(!visited[nx][ny]){
                                visited[nx][ny] = true;
                                q.add(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }

        System.out.println(totalRoomCnt+"\n"+maxRoomSize+"\n"+maxTwoRoomSize);
    }

    static boolean canMove(int x, int y, int i){
        int wall = map[x][y];
        return (wall&direction[i])!=direction[i];
    }

    static boolean isBound(int x, int y){
        return x>=0&&x<n&&y>=0&&y<m;
    }
}
