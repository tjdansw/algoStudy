package divide_conquer;

import java.io.*;
import java.util.*;

// 2263
public class Baek_2263 {
    static int[] inOrder, postOrder;
    static Map<Integer, Integer> inOrderIndex = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        inOrder = new int[n];
        postOrder = new int[n];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(st1.nextToken());
            postOrder[i] = Integer.parseInt(st2.nextToken());
        }

        for (int i = 0; i < n; i++) {
            inOrderIndex.put(inOrder[i], i);
        }

        buildPreOrder(0, n - 1, 0, n - 1);
        System.out.println(sb.toString());
    }

    private static void buildPreOrder(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) return;

        // 루트는 포스트오더의 마지막 값
        int root = postOrder[postEnd];
        sb.append(root).append(" ");

        int rootIdx = inOrderIndex.get(root);
        int leftSize = rootIdx - inStart;

        // 왼쪽 서브트리
        buildPreOrder(inStart, rootIdx - 1, postStart, postStart + leftSize - 1);
        // 오른쪽 서브트리
        buildPreOrder(rootIdx + 1, inEnd, postStart + leftSize, postEnd - 1);
    }
}
