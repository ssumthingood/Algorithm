import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] Ago;
    static int[] Bgo;
    static int[][] Point;
    static int T;
    static int SIZE = 10;
    static int M;
    static int A;
    static StringBuilder sb;
    static int[][] dir = {{0,0},{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for(int t=1;t<=T;t++) {
            int answer = 0;
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            Ago = new int[M+1];
            Bgo = new int[M+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=M;i++) {
                Ago[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=M;i++) {
                Bgo[i] = Integer.parseInt(st.nextToken());
            }
            Point = new int[A][4];
            for(int i=0;i<A;i++) {
                st = new StringTokenizer(br.readLine());
                Point[i][1] = Integer.parseInt(st.nextToken())-1;
                Point[i][0] = Integer.parseInt(st.nextToken())-1;
                Point[i][2] = Integer.parseInt(st.nextToken());
                Point[i][3] = Integer.parseInt(st.nextToken());
            }
             
            int Ar = 0;
            int Ac = 0;
            int Br = 9;
            int Bc = 9;
             
            for(int i=0;i<=M;i++) {
                Ar = Ar+dir[Ago[i]][0];
                Ac = Ac+dir[Ago[i]][1];
                Br = Br+dir[Bgo[i]][0];
                Bc = Bc+dir[Bgo[i]][1];
                int Max = 0;
                for(int j=0;j<A;j++) {
                    if(getMan(Point[j][0], Point[j][1], Ar, Ac, Point[j][2])) {
                        Max = Math.max(Max, Point[j][3]);
                        for(int k=0;k<A;k++) {
                            if(getMan(Point[k][0], Point[k][1], Br, Bc, Point[k][2])) {
                                if(j!=k) {
                                    Max = Math.max(Max, Point[j][3]+Point[k][3]);
                                }
                            }   
                        }                       
                    }else {
                        for(int k=0;k<A;k++) {
                            if(getMan(Point[k][0], Point[k][1], Br, Bc, Point[k][2])) {
                                Max = Math.max(Max,Point[k][3]);
                            }               
                        }   
                    }
                }
                answer+=Max;
            }
             
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
    static boolean getMan(int pointR, int pointC, int nowR, int nowC, int length) {
        return (Math.abs(pointR-nowR) + Math.abs(pointC-nowC)) <=length;
    }
}