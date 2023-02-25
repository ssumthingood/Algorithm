import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int[] arr;
	static int M;
	static int S;
	static int K;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr = new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			System.out.println(arr[K]-arr[S-1]);
		}
	}

}