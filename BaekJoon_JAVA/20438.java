import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_20438 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int K;
    static int Q;
    static int M;
    static int dp[];
    static boolean zzz[];
    static boolean school[];
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[N+3];
        zzz = new boolean[N+3];
        school = new boolean[N+3];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<K;i++){
            int sleep  = Integer.parseInt(st.nextToken());
            zzz[sleep] = true;
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<Q;i++){
            int target =Integer.parseInt(st.nextToken());
            int base = target;
            if(zzz[base]) continue;

            while(base<=N+2){
                if (!zzz[base]) {
                    school[base] = true;
                }
                base +=target;
            }
        }
        for(int i=3;i<=N+2;i++){
            int isGo;
            if(school[i]){
                isGo = 0;
            }else{
                isGo = 1;
            }
            dp[i] = isGo+dp[i-1];
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(dp[end]-dp[start-1]);
        }
    }
}