import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static long answer = 0;
    static long[] arr;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N+1];
        dp = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = dp[i-1]+arr[i];
        }
        for(int i=1;i<=N;i++){
            answer +=arr[i]*dp[i-1];
        }
        System.out.println(answer);
    }

}
