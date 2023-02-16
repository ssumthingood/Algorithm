import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br;
	static int N;
	static StringBuilder sb;
	static int R;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			R = Integer.parseInt(br.readLine());
			sb = new StringBuilder();
			if(R ==0) {
				sb.append("1 0\n");
			}else if(R==1) {
				sb.append("0 1\n");
			}else {
				dp = new int[2][41];
				dp[0][0] = 1;
				dp[1][0] = 0;
				dp[0][1] = 0;
				dp[1][1] = 1;
				
				for(int j=2;j<=R;j++) {
					dp[0][j] = dp[0][j-1]+dp[0][j-2];
					dp[1][j] = dp[1][j-1]+dp[1][j-2];
				}
				sb.append(dp[0][R]).append(" ").append(dp[1][R]).append("\n");
			}
			System.out.print(sb);
		}
	}
}