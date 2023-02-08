import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int M;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st=  new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dp = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				dp[i][j] = dp[i-1][j]+dp[i][j-1] - dp[i-1][j-1] + Integer.parseInt(st.nextToken());
			}
		}
		sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
//			System.out.println(dp[y2][x2]-dp[y1-1][x2]-dp[y2][x1-1]+dp[y1-1][x1-1]);
			sb.append(dp[y2][x2]-dp[y1-1][x2]-dp[y2][x1-1]+dp[y1-1][x1-1]).append("\n");
		}
		System.out.println(sb.toString());
	}
}