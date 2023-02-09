import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static int T;
    static int N;
    static int M;
    static int[][] board;
    static long[][] dp;
    static long[][] dp2;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            dp = new long[N+1][N+1];
            dp2 = new long[N-M+2][N-M+2];
 
            for(int i=1;i<=N;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=1;j<=N;j++) {
                    dp[i][j] = dp[i-1][j]+dp[i][j-1] - dp[i-1][j-1] + Integer.parseInt(st.nextToken());             
                    }
            }
             
            for(int i=1;i<=N-M+1;i++) {
                for(int j=1;j<=N-M+1;j++) {
                    dp2[i][j] = dp[i+M-1][j+M-1] - dp[i+M-1][j-1] - dp[i-1][j+M-1] + dp[i-1][j-1];
                    answer = (int) Math.max(answer,  dp2[i][j]);
                }
            }
 
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ").append(answer);
            System.out.println(sb);
            answer =0;
        }
    }
}