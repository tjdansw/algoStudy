package implement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_14725 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n, cnt;
    static String key;
    static HashMap<String, Node> list = new HashMap<>();
    static Node init,prev,next;
    static class Node{
        String name;
        HashMap<String, Node> set;

        public Node(String name) {
            this.name = name;
            set = new HashMap<>();
        }
    }


    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_14725.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            cnt = Integer.parseInt(st.nextToken());
            key = st.nextToken();
            init = list.getOrDefault(key,new Node(key));
            prev = init;
            for(int j = 1; j < cnt; j++){
                String tempKey = st.nextToken();
                next = prev.set.getOrDefault(tempKey,new Node(tempKey));
                prev.set.put(tempKey,next);
                prev = next;
            }
            list.put(key,init);
        }
        ArrayList<Node> nodes = new ArrayList<>(list.values());
        Collections.sort(nodes,(a,b)->(a.name).compareTo(b.name));
        for(Node node : nodes){
            sb.append(node.name).append("\n");
            dfs(node.set,1);
        }
        System.out.println(sb);
    }

    static void dfs(HashMap<String, Node> map,int depth){
        if(map.isEmpty()) return;
        StringBuilder prevSb = new StringBuilder();
        for(int i = 0;i<depth;i++) prevSb.append("--");
        ArrayList<Node> nodes = new ArrayList<>(map.values());
        Collections.sort(nodes,(a,b)->(a.name).compareTo(b.name));
        for(Node node : nodes){
            sb.append(prevSb.toString()).append(node.name).append("\n");
            dfs(node.set,depth+1);
        }
    }
}
