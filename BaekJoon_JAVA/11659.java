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
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st=  new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st=  new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			if(i==0) {
				arr[i] = Integer.parseInt(st.nextToken());
			}else {
				arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<M;i++) {
			st=  new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			if(start == 0) {
				System.out.println(arr[end]);
			}else {
				System.out.println(arr[end]-arr[start-1]);
			}
		}
	}
}