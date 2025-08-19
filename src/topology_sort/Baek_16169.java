package topology_sort;

import java.util.*;
import java.io.*;

// 16169
public class Baek_16169 {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer,ArrayList<int[]>> cumputerList = new HashMap<>();
        int maxRank = 0;
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int rank = Integer.parseInt(st.nextToken());
            maxRank = Math.max(maxRank,rank);
            int runTime = Integer.parseInt(st.nextToken());
            ArrayList<int[]> cumputers = cumputerList.getOrDefault(rank, new ArrayList<>());
            cumputers.add(new int[]{i,runTime});
            cumputerList.put(rank, cumputers);
        }
        ArrayList<int[]> prevWorks = new ArrayList<>();
        for(int[]c:cumputerList.get(1)){
            // prevTime, index
            prevWorks.add(new int[]{c[1], c[0]});
        }
        for(int rank = 2; rank <= maxRank; rank++) {
            ArrayList<int[]> works = new ArrayList<>();
            for (int[] computer:cumputerList.get(rank)){
                int maxTime = 0;
                int idx = computer[0];
                int runTime = computer[1];
                for(int[] prev:prevWorks){
                    int prevTime = prev[0];
                    int prevIdx = prev[1];
                    int totalTime = prevTime + ((idx-prevIdx)*(idx-prevIdx)) +runTime;
                    maxTime = Math.max(maxTime,totalTime);
                }
                works.add(new int[]{maxTime, idx});
            }
            prevWorks = works;
        }

        int max = 0;
        for(int[] work:prevWorks){
            max = Math.max(max,work[0]);
        }
        System.out.println(max);
    }
}
