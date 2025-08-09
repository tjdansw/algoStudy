package graph;

import java.util.*;
import java.io.*;

// 4256
public class Baek_4256 {
    static int n;
    static int[] preorder, inorder;
    static HashMap<Integer, Integer> inorderIndex;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < t; tc++) {
            n = Integer.parseInt(br.readLine());
            preorder = new int[n];
            inorder = new int[n];
            inorderIndex =  new HashMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                preorder[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                inorder[i] = Integer.parseInt(st.nextToken());
                inorderIndex.put(inorder[i], i);
            }
            buildPostorder(0,0,n-1);
            sb.append('\n');
        }
        System.out.println(sb);
    }
    static void buildPostorder(int preStart, int inStart, int inEnd){
        if(preStart >= n || inStart>inEnd) return;

        int root = preorder[preStart];
        int rootIdx = inorderIndex.get(root);
        int leftSize = rootIdx - inStart;

        // 왼쪽 서브트리
        buildPostorder(preStart+1, inStart,rootIdx-1);
        // 오른쪽 서브트리
        buildPostorder(preStart+leftSize+1, rootIdx+1, inEnd);
        sb.append(root).append(" ");
    }
}
