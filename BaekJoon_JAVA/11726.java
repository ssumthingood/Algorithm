import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class java11726 {
	static BufferedReader br;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N+1];
		dp[1] = 1L;
		if(N==1) {System.out.println(1); return;}
		dp[2] = 2L;
		if(N==2) {System.out.println(2); return;}
		for(int i=3;i<=N;i++) {
			dp[i] = (dp[i-1]+dp[i-2])%10007;
			//문제가 말을 줜나 이상하게 해놨다. 마지막 값을 나눈걸 출력하는건지 매 값에다 10007을 나누란건지(일단 후자로 풀림)
		}
		System.out.println(dp[N]);
 	}

}
