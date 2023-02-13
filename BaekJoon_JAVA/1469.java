import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int remain;
	static int[] answer;
	static boolean[] visited;
	static void makeArray(int n) {
		if(n==N*2) {
			for(int i=0;i<N*2;i++) {
				System.out.print(answer[i]+" ");
			}
			System.exit(0);
		}
		
		if(answer[n] !=-1) {
			makeArray(n+1);
		}
		
		for(int i=0;i<N;i++) {
			if(!visited[i] && n+arr[i]+1<2*N && answer[n]== -1 && answer[n+arr[i]+1] ==-1) {
				visited[i] = true;
				answer[n] = arr[i];
				answer[n+arr[i]+1] = arr[i];
				makeArray(n+1);
				visited[i] = false;
				answer[n] = -1;
				answer[n+arr[i]+1] = -1;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		remain = N;
		arr = new int[N];
		answer = new int[N*2];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<N*2;i++) {
			answer[i] = -1;
		}
		Arrays.sort(arr);
		makeArray(0);
		System.out.println(-1);
	}
}