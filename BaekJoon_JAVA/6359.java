import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	
	static void open(boolean[] arr, int N) {
		for(int i=1;i<=N;i++) {
			for(int j=1;j<arr.length;j++) {
				if(j%i == 0) {
					arr[j] = !arr[j];
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<T;i++) {
			int answer = 0;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			boolean[] opened = new boolean[N+1];
			open(opened,N);
			for(int j = 0;j<opened.length;j++) {
				if(opened[j]) answer++;
			}
			System.out.println(answer);
		}
	}

}
