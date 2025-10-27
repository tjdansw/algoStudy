package implement;

import java.util.*;
import java.io.*;

// 17135
public class Baek_17135 {
    static int n, m, d, size=0;
    static ArrayList<Enemy> enemyList = new ArrayList<>();
    static ArrayList<ArcherUnit> archerList = new ArrayList<>();

    static class Enemy {
        int x, y;
        int idx;

        public Enemy(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }

        void move(){
            x++;
        }
    }

    static class ArcherUnit{
        int[] position = new int[3];
        boolean[] isKillEnemy;
        int killCnt = 0;

        public ArcherUnit(int[] temp) {
            for (int i = 0; i < 3; i++) {
                position[i] = temp[i];
            }
            this.isKillEnemy = new boolean[size];
        }

        boolean isKillEnemy(Enemy enemy){
            return isKillEnemy[enemy.idx];
        }

        void killEnemy(Enemy enemy){
            if(!isKillEnemy[enemy.idx]){
                isKillEnemy[enemy.idx] = true;
                killCnt++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 1){
                    enemyList.add(new Enemy(i, j ,size++));
                }
            }
        }

        dfs(0,0, new int[3]);

        while (true){
            Stack<Enemy> targets = new Stack<>();
            for(ArcherUnit unit: archerList){
                for(int y:unit.position){
                    Enemy target = null;
                    int minLen = 100;
                    for (Enemy e : enemyList) {
                        if(e.x==n||unit.isKillEnemy(e)) continue;
                        int len = Math.abs(e.x-n)+Math.abs(e.y-y);
                        if(len<=d&&(target==null||(len<minLen)||(len==minLen&&target.y>e.y))){
                            minLen = len;
                            target = e;
                        }
                    }
                    if(target!=null){
                        targets.add(target);
                    }
                }
                while (!targets.isEmpty()){
                    unit.killEnemy(targets.pop());
                }
            }

            boolean flag = true;
            for (Enemy e : enemyList) {
                if(e.x==n) continue;
                flag = false;
                e.move();
            }
            if(flag){
                break;
            }
        }

        int max = 0;
        for(ArcherUnit unit:archerList){
            max = Math.max(max, unit.killCnt);
        }
        System.out.println(max);
    }

    static void dfs(int start, int dept, int[] p){
        if(dept == 3){
            archerList.add(new ArcherUnit(p));
            return;
        }
        for (int i = start; i < m; i++) {
            p[dept] = i;
            dfs(i+1, dept+1, p);
        }
    }
}
