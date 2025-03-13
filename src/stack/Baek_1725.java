package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek_1725 {
    static BufferedReader br;

    static int n;
    static long[] list;
    static Stack<Integer> stack;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        list = new long[n];
        for (int i = 0; i < n; i++) {
            list[i] = Long.parseLong(br.readLine());
        }
        System.out.print(getMaxArea());
    }

    public static long getMaxArea() {
        int n = list.length;
        stack = new Stack<>();
        long maxArea = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && list[stack.peek()] > list[i]) {
                int idx = stack.pop();
                long height = list[idx];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                long area = height * width;
                if (area > maxArea) {
                    maxArea = area;
                }
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int idx = stack.pop();
            long height = list[idx];
            int width = stack.isEmpty() ? n : n - stack.peek() - 1;
            long area = height * width;
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }
}
