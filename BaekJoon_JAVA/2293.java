import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int K;
	static int[] t;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		t = new int[N];
		for(int i=0;i<N;i++) {
			t[i] = Integer.parseInt(br.readLine());
		}
		dp = new int[N][K+1];
		for(int i=0;i<N;i++) {
			for(int j=1;j<=K;j++) {
				if(i==0) {
					if(j<t[i]) {
						dp[i][j] = 0;
					}else if(t[i]==j) {
						dp[i][j] = 1;
					}else {
						dp[i][j] = dp[i][j-t[i]];
					}
				}else {
					if(j<t[i]) {
						dp[i][j] = dp[i-1][j];
					}else if(t[i]==j) {
						dp[i][j] = 1+dp[i-1][j];
					}else {
						dp[i][j] = dp[i-1][j]+dp[i][j-t[i]];
					}
				}
			}
		}
		System.out.println(dp[N-1][K]);
	}
}