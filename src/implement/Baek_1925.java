package implement;

import java.util.*;
import java.io.*;

// 1925
public class Baek_1925 {
    static long[][] points = new long[3][2];
    static long[] lineLen = new long[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i][0] = Long.parseLong(st.nextToken());
            points[i][1] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return Long.compare(a[1], b[1]);
            }
            return Long.compare(a[0], b[0]);
        });
        getLineLen();
        if(isLine()){
            System.out.println("X");
        }else if(isJungTriangle()){
            System.out.println("JungTriangle");
        }else if(isDunkak2Triangle()){
            System.out.println("Dunkak2Triangle");
        }else if(isJikkak2Triangle()){
            System.out.println("Jikkak2Triangle");
        }else if(isYeahkak2Triangle()){
            System.out.println("Yeahkak2Triangle");
        }else if(isDunkakTriangle()){
            System.out.println("DunkakTriangle");
        }else if(isJikkakTriangle()){
            System.out.println("JikkakTriangle");
        }else if(isYeahkakTriangle()){
            System.out.println("YeahkakTriangle");
        }
    }

    private static void getLineLen(){
        for(int i =0; i<3; i++){
            long a = points[i][0] - points[(i+1)%3][0];
            long b = points[i][1] - points[(i+1)%3][1];
            lineLen[i] = a*a + b*b;
        }
        Arrays.sort(lineLen);
    }

    private static boolean isLine() {
        long gradientX = points[1][0] - points[0][0];
        long gradientY = points[1][1] - points[0][1];
        if(gradientX == 0){
            return points[0][0] == points[2][0];
        }
        long y = gradientX*(points[2][1]-points[0][1]);
        long x = gradientY*(points[2][0]-points[0][0]);
        return x==y;
    }

    private static boolean isJungTriangle() {
        for(int i =1; i<3; i++){
            if(lineLen[i] != lineLen[i-1]){
                return false;
            }
        }
        return true;
    }

    private static boolean isDunkak2Triangle() {
        int cnt = 0;
        for(int i =0; i<3; i++){
            int nextIdx = (i+1)%3;
            if(lineLen[i] == lineLen[nextIdx]){
                cnt++;
            }
        }
        if(cnt == 1){
            return lineLen[2]>lineLen[0]+lineLen[1];
        }
        return false;
    }

    private static boolean isJikkak2Triangle() {
        int cnt = 0;
        for(int i =0; i<3; i++){
            if(lineLen[i] == lineLen[(i+1)%3]){
                cnt++;
            }
        }
        if(cnt == 1){
            return lineLen[2]==lineLen[0]+lineLen[1];
        }
        return false;
    }

    private static boolean isYeahkak2Triangle() {
        int cnt = 0;
        for(int i =0; i<3; i++){
            if(lineLen[i] == lineLen[(i+1)%3]){
                cnt++;
            }
        }
        if(cnt == 1){
            return lineLen[2]<lineLen[0]+lineLen[1];
        }
        return false;
    }

    private static boolean isDunkakTriangle() {
        int cnt = 0;
        for(int i =0; i<3; i++){
            if(lineLen[i] == lineLen[(i+1)%3]){
                cnt++;
            }
        }
        if(cnt == 0){
            return lineLen[2]>lineLen[0]+lineLen[1];
        }
        return false;
    }

    private static boolean isJikkakTriangle() {
        int cnt = 0;
        for(int i =0; i<3; i++){
            if(lineLen[i] == lineLen[(i+1)%3]){
                cnt++;
            }
        }
        if(cnt == 0){
            return lineLen[2]==lineLen[0]+lineLen[1];
        }
        return false;
    }

    private static boolean isYeahkakTriangle() {
        int cnt = 0;
        for(int i =0; i<3; i++){
            if(lineLen[i] == lineLen[(i+1)%3]){
                cnt++;
            }
        }
        if(cnt == 0){
            return lineLen[2]<=lineLen[0]+lineLen[1];
        }
        return false;
    }
}

