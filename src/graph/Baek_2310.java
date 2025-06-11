package graph;

import java.io.*;
import java.util.*;

public class Baek_2310 {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static Room[] list = new Room[1001];

    static class Room{
        String type;
        int cost;
        ArrayList<Integer> edges = new ArrayList<>();

        public Room(String type, int cost) {
            this.type = type;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while((n = Integer.parseInt(br.readLine())) != 0) {
            list[0] = new Room("E",0);
            list[0].edges.add(1);
            for(int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                String type = st.nextToken();
                int cost = Integer.parseInt(st.nextToken());
                list[i] = new Room(type, cost);
                int next;
                while((next = Integer.parseInt(st.nextToken()))!=0) {
                    list[i].edges.add(next);
                }
            }

            boolean flag = false;
            boolean[][] visited = new boolean[n+1][501];
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{0, 0});
            visited[0][0] = true;

            while(!q.isEmpty()) {
                int[] cur = q.poll();
                int idx = cur[0];
                int money = cur[1];

                if(idx == n) {
                    flag = true;
                    break;
                }

                for(int next : list[idx].edges) {
                    int nextMoney = money;
                    Room nextRoom = list[next];

                    if(nextRoom.type.equals("L")) {
                        if(nextRoom.cost > nextMoney)
                            nextMoney = nextRoom.cost;
                    } else if(nextRoom.type.equals("T")) {
                        if(nextMoney < nextRoom.cost) continue;
                        nextMoney -= nextRoom.cost;
                    }

                    if(!visited[next][nextMoney]) {
                        visited[next][nextMoney] = true;
                        q.add(new int[]{next, nextMoney});
                    }
                }
            }

            sb.append(flag?"Yes\n":"No\n");
        }
        System.out.print(sb);
    }
}
