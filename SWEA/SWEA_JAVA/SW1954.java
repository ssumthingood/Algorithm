import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int T;
    static int N;
    static int[][] board;
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for(int t=1;t<=T;t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            board = new int[N][N];
            makeSnail(0,0,0,1);
            sb = new StringBuilder();
            sb.append("#").append(t).append("\n");
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    sb.append(board[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb.toString());
        }
    }
     
    static void makeSnail(int r, int c, int d, int value) {
        board[r][c] = value;
        if(value == N*N) return;
        if(isIn(r+dir[d][0], c+dir[d][1])) {
            makeSnail(r+dir[d][0], c+dir[d][1], d, value+1);
        }else {
            makeSnail(r,c,(d+1)%4,value);
        }
    }
     
    static boolean isIn(int r, int c) {
        if(r>=0 && r<N && c>=0 && c<N && board[r][c] ==0) {
            return true;
        }return false;
    }
}