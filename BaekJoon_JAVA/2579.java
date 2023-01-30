import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1번 계단을 무조건 밟고 시작해야 하는 게 아니었다...(2번부터 시작도 가능)
// 이거땜에 개삽질함...

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int[] a = new int[N+1];
		int[] d = new int[N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			d[i] = Integer.parseInt(st.nextToken());
		}
		
		a[1] = d[1];
		if(N==1) {
		System.out.println(a[1]);
		return;
		}
		a[2] = Math.max(d[1]+d[2], d[2]);
		if(N==2) {
		System.out.println(a[2]);
		return;
		}
		a[3] = Math.max(d[1]+d[3],d[2]+d[3]);
		if(N==3) {
		System.out.println(a[3]);
		return;
		}
		
		for(int i=4;i<=N;i++) {
			a[i] = Math.max(a[i-2]+d[i],a[i-3]+d[i]+d[i-1]);
		}
		System.out.println(a[N]);
	}

}