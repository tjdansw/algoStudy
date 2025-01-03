package brute_force;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2798 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n, m, result=0;
    static int[] card = new int[100];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_2798.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) card[i]=Integer.parseInt(st.nextToken());

        dfs(0,0,0);
        System.out.println(result);
    }

    static void dfs(int next,int dept, int sum) {
        if(dept==3) {
            if(sum<=m&&m-sum<m-result){
                result = sum;
            }
            return;
        }
        for(int i = next;i<n;i++){
            dfs(i+1,dept+1,sum+card[i]);
        }
    }
}
