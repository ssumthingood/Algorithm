import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int M;
	static int[] arr;
	static long[] dp;
	static long[] remains;
	static long answer = 0;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		dp = new long[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		remains = new long[M];
		for(int i=1;i<=N;i++) {
			dp[i] = dp[i-1]+arr[i];
		}
		
		for(int i=0;i<=N;i++) {
			remains[(int) (dp[i]%M)]++;
		}
		
		for(int i=0;i<M;i++) {
			if(remains[i] >2) {
				answer += remains[i] * (remains[i]-1) /2;			
			}else if(remains[i] == 2) {
				answer +=1;
			}else {
				continue;
			}
		}
		System.out.println(answer);
	}
}
